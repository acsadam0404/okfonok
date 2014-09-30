package hu.okfonok.session;

import hu.okfonok.beans.UserBean
import hu.okfonok.entities.user.User
import hu.okfonok.utils.ServiceLocator

class SessionUtils {
	static User getUser() {
		return ServiceLocator.getBean(UserBean).user
	}
	
	private SessionUtils() {
		/* util */
	}
}
