package hu.okfonok.entities

import javax.persistence.Embeddable
import javax.validation.constraints.Digits

import org.hibernate.annotations.Formula

@Embeddable
class Address implements Serializable {
	@Digits(integer = 4, fraction = 0)
	Integer zipcode
	
	String city
	
	String other
	
	@Formula("0")
	private int dummyFieldForHibernateNotNullEmbedded;
	
	@Override
	String toString() {
		"$zipcode $city, $other" 
	}
}
