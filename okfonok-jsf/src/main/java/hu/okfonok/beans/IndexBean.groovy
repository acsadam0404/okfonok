package hu.okfonok.beans

import hu.okfonok.services.UserService

import org.primefaces.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component("indexBean")
@Scope("session")
class IndexBean implements Serializable{
	@Autowired
	private UserService userService

	@Autowired
	private UserBean userBean
	
	private boolean alreadyShowedFirstLoginDialog 
	
	/**
	 *  első belépésnél megmutatja a dialógust
	 */
	def showOnFirstLogin() {
		if (!alreadyShowedFirstLoginDialog && !userBean.user.lastLogin) {
			alreadyShowedFirstLoginDialog = true
			RequestContext.getCurrentInstance().execute("PF('dlgFirstLogin').show();")
		}
	}
}
