package hu.okfonok.entities.user

import javax.persistence.Column
import javax.persistence.Embeddable

/**
 * 
 * @author Ács Ádám
 *
 */
@Embeddable
class Certification {
	
	String idCardNumber
	
	byte[] idCardPicture
	
	String addressCardNumber

	byte[] addressCardPicture
	
	Boolean certified
}
