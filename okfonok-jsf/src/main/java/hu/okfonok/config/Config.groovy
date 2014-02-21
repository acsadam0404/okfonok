package hu.okfonok.config

import hu.okfonok.beans.UserBean
import hu.okfonok.utils.ServiceLocator

/**
 * 
 * @author Ács Ádám
 *
 */
class Config {
	private static final String ROOT = "/okfonok"
	 
	static String getUserProfilePath() {
		return "${ROOT}/users/${ServiceLocator.getBean(UserBean.class).user.userName}"
	}
	
	static String getStaticContextPath() {
		return "${ROOT}/static"
	}
	
	private Config() {
		/* private */
	}
}
