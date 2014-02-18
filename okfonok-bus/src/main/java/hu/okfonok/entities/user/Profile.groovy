package hu.okfonok.entities.user

import javax.persistence.Column;
import javax.persistence.Embeddable
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size

/**
 * 
 * @author Ács Ádám
 *
 */
@Embeddable
class Profile implements Serializable {
	byte[] profilePicture
	
	@Size(max = 1000)
	String introduction
	
	@Size(min=4)
	String surName
	
	@Size(min=4)
	String firstName
	
	@NotNull
	@Size(min = 4)
	String email

	/* maskedinput validálja */	
	String phoneNumber
	
	Boolean employer
	
	Boolean employee
}
