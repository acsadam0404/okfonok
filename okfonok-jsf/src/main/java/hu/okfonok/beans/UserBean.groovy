package hu.okfonok.beans

import hu.okfonok.entities.user.User
import hu.okfonok.services.UserService

import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.inject.Named

import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("userBean")
@Scope("session")
class UserBean implements Serializable {
	private User user

	@Inject
	private UserService userService
	
	@PostConstruct
	void postConstruct() {
		user = userService.findByUserName("aacs")
	}

	User getUser() {
		return user
	}
}
