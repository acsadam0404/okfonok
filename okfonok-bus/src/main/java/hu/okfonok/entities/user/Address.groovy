package hu.okfonok.entities.user

import javax.persistence.Embeddable
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Embeddable
class Address implements Serializable {
	String state
	
	@Digits(integer = 4, fraction = 0)
	Integer zipcode
	
	String city
	
	String street
	
	String streetNumber
}
