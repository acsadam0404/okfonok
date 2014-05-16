package hu.okfonok.beans

import hu.okfonok.entities.user.User
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
@Named("userBean")
@Scope("session")
class UserBean implements Serializable {
	private transient User user

	User getUser() {
		if (user == null) {
			def principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
			if (principal && principal instanceof UserDetails) {
				return ServiceLocator.getBean(UserService.class).findByUserName(principal.username)
			}
		}
		return user
	}
}
