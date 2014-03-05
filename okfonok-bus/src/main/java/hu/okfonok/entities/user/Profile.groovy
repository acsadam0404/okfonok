package hu.okfonok.entities.user

import javax.persistence.Embeddable
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

import org.hibernate.annotations.Formula

/**
 * 
 * @author Ács Ádám
 *
 */
@Embeddable
class Profile implements Serializable {

	String profileImagePath

	@Size(max = 1000)
	String introduction

	@Size(min=1, max = 100)
	String lastName

	@Size(min=1, max=100)
	String firstName

	@NotNull
	@Size(min = 4)
	String email

	/* maskedinput validálja */	
	String phoneNumber

	Boolean employer

	Boolean employee

	Boolean personalEmployer

	Boolean companyEmployer

	String facebookValidatedId
	
	@Formula("0")
	private int dummyFieldForHibernateNotNullEmbedded;
	
	String getRealName() {
		return lastName + " " + firstName
	}
}
