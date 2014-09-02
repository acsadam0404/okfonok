package hu.okfonok.events

import java.util.Date

import groovy.transform.EqualsAndHashCode
import groovy.transform.Immutable

@EqualsAndHashCode
@Immutable
class LoginEvent {
	String username
	Date datum}
