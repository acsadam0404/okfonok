package hu.okfonok.beans.events;

import groovy.transform.EqualsAndHashCode;
import hu.okfonok.entities.user.User

@EqualsAndHashCode
class LoginAttemptEvent {
	String username
	
	LoginAttemptEvent(String username) {
		this.username = username
	}
}
