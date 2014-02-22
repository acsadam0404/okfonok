package hu.okfonok.utils

/**
 * 
 * @author Ács Ádám
 *
 */
class Config {
	private static final String ROOT = "/okfonok"
	 
	static String getUserProfilePath() {
		return "${ROOT}/users"
	}
	
	static String getStaticContextPath() {
		return "${ROOT}/static"
	}
	
	static String getEmailTemplatePath() {
		return "${ROOT}/email"
	}
	
	private Config() {
		/* private */
	}
}
