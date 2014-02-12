package hu.jobly.beans

import hu.jobly.entities.User
import hu.jobly.services.UserService

import javax.annotation.PostConstruct;
import javax.inject.Named

import org.springframework.beans.factory.annotation.Autowired
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
	private User user

	@Autowired
	private UserService userService
	
	@PostConstruct
	void postConstruct() {
		user = userService.findByUserName("aacs")
	}

	User getUser() {
		return user
	}
}
