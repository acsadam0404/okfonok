package hu.okfonok.beans

import hu.okfonok.entities.user.User
import hu.okfonok.services.UserService

import javax.annotation.PostConstruct

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component("indexBean")
@Scope("view")
class IndexBean implements Serializable{
	@Autowired
	private UserService userService

}
