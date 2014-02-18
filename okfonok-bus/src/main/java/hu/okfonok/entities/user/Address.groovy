package hu.okfonok.entities.user

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Embeddable
class Address {
	String state
	
	@Min(4L)
	@Max(4L)
	Integer zipcode
	
	String city
	
	String street
	
	String streetNumber
}
