package hu.okfonok.beans.events;

import groovy.transform.EqualsAndHashCode
import groovy.transform.Immutable
import hu.okfonok.entities.user.User

@EqualsAndHashCode
@Immutable
class LoginAttemptEvent {
	String username
}
