package hu.okfonok.social.facebook

import javax.inject.Named

import org.springframework.social.facebook.api.Facebook
import org.springframework.social.facebook.api.FacebookProfile
import org.springframework.social.facebook.api.impl.FacebookTemplate

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("facebookRegistration")
class FacebookRegistration {
	void register() {
		Facebook facebook = new FacebookTemplate();
		FacebookProfile profile = facebook.userOperations().getUserProfile();
		print profile.getId()
	}
}
