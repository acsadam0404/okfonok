package hu.okfonok.beans;

import hu.okfonok.beans.events.LoginAttemptEvent
import hu.okfonok.entities.user.User
import hu.okfonok.events.LoginEvent
import hu.okfonok.services.UserService
import hu.okfonok.utils.EventBus
import hu.okfonok.utils.ServiceLocator;

import javax.faces.context.ExternalContext
import javax.faces.context.FacesContext
import javax.faces.event.PhaseEvent
import javax.faces.event.PhaseId
import javax.faces.event.PhaseListener
import javax.persistence.NoResultException
import javax.servlet.RequestDispatcher
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest

import org.apache.commons.lang3.RandomStringUtils
import org.apache.log4j.Logger
import org.brickred.socialauth.AuthProvider
import org.brickred.socialauth.Profile
import org.brickred.socialauth.SocialAuthConfig
import org.brickred.socialauth.SocialAuthManager
import org.brickred.socialauth.util.SocialAuthUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.WebAttributes

import com.google.common.eventbus.Subscribe;

/**
 * Lekezeli a social és a spring securitys authentikációt.
 * 
 * @author Ács Ádám
 * @author http://slackspace.de/articles/custom-login-page-with-jsf-and-spring-security-3-2/
 * @author http://mrj4mes.blogspot.hu/2013/03/how-to-implement-facebook-login-in-jsf.html
 *
 */
@org.springframework.stereotype.Component(value = "userSessionBean")
@Scope("session")
class UserSessionBean implements Serializable, PhaseListener {
	private static Logger log = Logger.getLogger(UserSessionBean.class)

	SocialAuthManager manager
	String originalURL
	String providerID

	@Autowired
	private UserDetailsService userDetailsService
	@Autowired
	private RegistrationBean registrationService
	@Autowired
	private UserService userService
	
	UserSessionBean() {
		EventBus.register(this)
	}
	
	@Subscribe
	void handleLoginAttempt(LoginAttemptEvent event) {
		try {
			login(event.username)
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.redirect(externalContext.getRequestContextPath() + "/index.xhtml")
		} catch (e) {
			log.error("sikertelen bejelentkezés", e)
		}
	}

	void socialConnect() throws Exception {
		// Put your keys and secrets from the providers here
		Properties props = System.getProperties();
		props.put("graph.facebook.com.consumer_key", "1463647647192269");
		props.put("graph.facebook.com.consumer_secret", "f1a51287104f157348ffa321aa74d5b9");
		// Define your custom permission if needed
		props.put("graph.facebook.com.custom_permissions", "publish_stream,email,user_birthday,user_location,offline_access");

		// Initiate required components
		SocialAuthConfig config = SocialAuthConfig.getDefault();
		config.load(props);
		manager = new SocialAuthManager();
		manager.setSocialAuthConfig(config);

		// 'successURL' is the page you'll be redirected to on successful login
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String successURL = externalContext.getRequestContextPath() + "/socialLoginSuccess.xhtml" 
		String authenticationURL = manager.getAuthenticationUrl(providerID, successURL)
		externalContext.redirect(authenticationURL)
	}

	void socialPullUserInfo() {
		try {
			// Pull user's data from the provider
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			Map map = SocialAuthUtil.getRequestParametersMap(request);
			if (this.manager != null) {
				AuthProvider provider = manager.connect(map);
				Profile profile = provider.getUserProfile();
				socialRegisterIfNeeded(profile)
				login(profile.validatedId)

				// Do what you want with the data (e.g. persist to the database, etc.)
				log.trace("User's Social profile: " + profile);

				// Redirect the user back to where they have been before logging in
				externalContext.redirect(originalURL);

			} else {
				externalContext.redirect(externalContext.getRequestContextPath() + "/info.xhtml");
			}
		} catch (Exception ex) {
			log.error(ex);
		}
	}

	void socialLogout() {
		try {
			// Disconnect from the provider
			manager.disconnectProvider(providerID);

			// Invalidate session
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			externalContext.invalidateSession();

			FacesContext.getCurrentInstance().getExternalContext().redirect(externalContext.getRequestContextPath() + "/info.xhtml");
		} catch (IOException ex) {
			log.error(ex)
		}
	}

	/**
	 * regisztrálja a usert (perzisztálja adatbázisban) ha még nem volt userid. 
	 * Épít arra, hogy a facebook ugyanazt a validatedId-t adja mindig ugyanarra a userre
	 * @param socialProfile
	 */
	void socialRegisterIfNeeded(Profile socialProfile) {
		String userName = socialProfile.email

		try {
			userService.findByUserName(userName)
		}
		catch (NoResultException nre) {
			User user = new User()

			user.profile.firstName = socialProfile.firstName
			user.profile.lastName = socialProfile.lastName
			user.profile.profileImagePath = socialProfile.profileImageURL
			user.userName = socialProfile.email
			user.enabled = true
			user.providerId = socialProfile.providerId
			user.userName = userName
			user.password = RandomStringUtils.randomAlphanumeric(10) 

			registrationService.register(user)
		}
	}

	/**
	 * Ez a metódus hívandó a social login után. Ez programból authentikálj a usert. 
	 * @param userName
	 */
	void login(String userName) {
		UserDetails userDetails = ServiceLocator.getBean(UserDetailsService).loadUserByUsername(userName);
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	/**
	 * Ebben az esetben nem kell socialLogin! Ezt a metódus nem programból loginol, hanem actionként van megadva a login.xhtml-ben lévő gombnak.
	 * Redirects the login request directly to spring security check. Leave this method as it is to properly support spring security.
	 *
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String doLogin() throws ServletException, IOException {
		ExternalContext context = FacesContext.currentInstance.externalContext
		RequestDispatcher dispatcher = context.request.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(context.request, context.response)
		FacesContext.currentInstance.responseComplete()
		//TODO ha nem sikerült a login ne hivjuk meg
		EventBus.post(new LoginEvent(context.request.getParameter("j_username"), new Date()))
		
		return "index.xhtml";
	}

	public void afterPhase(PhaseEvent event) {
		/* ez nem kell */
	}

	public void beforePhase(PhaseEvent event) {
		Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);

		if (e instanceof BadCredentialsException) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
		}
	}

	public String doLogout() {
		/* manager abban az esetben null, ha nem volt sociallogin */
		if (manager) {
			socialLogout();
		}
		SecurityContextHolder.clearContext()
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession()
		return "info.xhtml?faces-redirect=true"

	}
	
	PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE
	}

	void setOriginalURL(String originalURL) {
		this.originalURL = originalURL
	}
}