package hu.okfonok.entities.user

import javax.persistence.Embeddable

import org.hibernate.annotations.Formula

/**
 * 
 * @author Ács Ádám
 *
 */
@Embeddable
class Certification implements Serializable {
	
	String idCardNumber
	
	byte[] idCardPicture
	
	String addressCardNumber

	byte[] addressCardPicture
	
	Boolean certified
	
	@Formula("0")
	private int dummyFieldForHibernateNotNullEmbedded;
}
