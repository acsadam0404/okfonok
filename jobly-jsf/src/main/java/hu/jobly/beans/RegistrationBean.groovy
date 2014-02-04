package hu.jobly.beans;

import hu.jobly.entities.User
import hu.jobly.services.RoleService
import hu.jobly.services.UserService

import javax.faces.bean.SessionScoped

import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.security.authentication.encoding.Md5PasswordEncoder
import org.springframework.stereotype.Component

/**
 * 
 * @author Ács Ádám
 *
 */
@Component("registrationBean")
@SessionScoped
class RegistrationBean implements Serializable {
	private static final Logger log = Logger.getLogger(RegistrationBean.class)

	@Autowired
	private RoleService roleService
	@Autowired
	private UserService userService
	@Autowired
	private Md5PasswordEncoder passwordEncoder

	User user = new User()

	void register() {
		try {
			userService.create(user);
			user.roles.add(roleService.getUserRole())
			user.password = passwordEncoder.encodePassword(user.password, "basicsalt")
			userService.save(user)
			user = new User();
		} 
		catch (DataIntegrityViolationException divEx) {
			log.error("Sikertelen regisztráció!", divEx);
		}
		catch (Exception e) {
			log.fatal("Sikertelen regisztráció!", e);
		}
	}
	
	void reset() {
		user = new User()
	}
}
