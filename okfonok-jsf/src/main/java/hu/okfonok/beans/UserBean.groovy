package hu.okfonok.beans

import hu.okfonok.entities.Skill;
import hu.okfonok.entities.user.User
import hu.okfonok.entities.user.UserSkill
import hu.okfonok.services.UserService
import hu.okfonok.utils.ServiceLocator

import javax.inject.Inject
import javax.inject.Named

import org.springframework.context.annotation.Scope
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

/**
 * 
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component("userBean")
@Scope("session")
class UserBean implements Serializable {
	private transient User user
	
	/**
	 * Ne használd közvetlenül! SessionUtils.user kell, az statikus
	 * @return
	 */
	User getUser() {
		if (user == null) {
			def principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
			if (principal && principal instanceof UserDetails) {
				user = ServiceLocator.getBean(UserService.class).findByUserName(principal.username)
			}
		}
		
		return user
	}
}
