package hu.okfonok.beans;

import hu.okfonok.entities.user.User

import org.primefaces.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Feladás 5. - Profil megtekintés
 * https://github.com/acsadam0404/okfonok/issues/56
 */
@Component("userProfileBean")
@Scope("session")
class UserProfileBean {
	
	User user
	
	@Autowired
	private SkillsBean skillsBean
	
	void showDialog(User user) {
		this.user = user
		skillsBean.user = user
		
		Map options = [
			modal:	true,
			draggable:	false,
			resizable:	false,
			contentHeight: 320
		]

		RequestContext.getCurrentInstance().openDialog("fragments/index/profile", options, null)
	}
}
