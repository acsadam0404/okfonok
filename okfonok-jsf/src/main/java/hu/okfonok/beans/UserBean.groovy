package hu.okfonok.beans

import hu.okfonok.entities.user.Skill
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
@org.springframework.stereotype.Component("userBean")
@Scope("session")
class UserBean implements Serializable {
	private transient User user

	User getUser() {
		if (user == null) {
			def principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
			if (principal && principal instanceof UserDetails) {
				user = ServiceLocator.getBean(UserService.class).findByUserName(principal.username)
			}
		}
		
		
		testTempData()
		return user
	}
	
	void testTempData() {
		if (user.skills.empty) {
			user.skills.add(new Skill(name: 'asd', rating: 3, ownRating: 5))
			user.skills.add(new Skill(name: 'bsd', rating: 5, ownRating: 5))
			user.skills.add(new Skill(name: 'csd', rating: 2, ownRating: 3))
			user.skills.add(new Skill(name: 'dsd', rating: 1, ownRating: 2))
			user.skills.add(new Skill(name: 'esd', rating: 5, ownRating: 3))
			user.skills.add(new Skill(name: 'fsd', rating: 4, ownRating: 4))
			user.skills.add(new Skill(name: 'gsd', rating: 5, ownRating: 5))
			user.skills.add(new Skill(name: 'hsd', rating: 3, ownRating: 2))
		}
	}
}
