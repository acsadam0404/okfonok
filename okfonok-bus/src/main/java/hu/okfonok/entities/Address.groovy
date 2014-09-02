package hu.okfonok.entities

import javax.persistence.Embeddable
import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula

@Embeddable
class Address implements Serializable {
	@Digits(integer = 4, fraction = 0)
	@NotNull
	Integer zipcode
	
	@NotNull
	String city
	
	String other
	
	@Formula("0")
	private int dummyFieldForHibernateNotNullEmbedded
	
	private transient String zipcodeAndCity
	
	@Override
	String toString() {
		"${zipcode?:''} ${city?:''} ${city ? ', ':''} ${other?:''}" 
	}

	/**
	 * zipcode - city formában kell megadni	
	 */
	void setZipcodeAndCity(String zipcodeAndCity) {
		def split = zipcodeAndCity.split(" - ")
		zipcode = Integer.valueOf(split[0])
		city = split[1]
	}
	
	String getZipcodeAndCity() {
		if (!zipcode || !city) {
			return ""
		}
		return "$zipcode - $city"
	}
	
	void setZipcode(Integer zipcode) {
		this.zipcode = zipcode
		if (zipcode) {
			//TODO
			city = "TODO beemelni regisztrációkor"
		}
	}
}
