package hu.okfonok.entities.user

import groovy.transform.EqualsAndHashCode;

import javax.persistence.Embeddable

import org.hibernate.annotations.Formula

/**
 * 
 * @author Ács Ádám
 *
 */
@Embeddable
@EqualsAndHashCode
class Certification implements Serializable {
	
	String idCardNumber
	
	byte[] idCardPicture
	
	String addressCardNumber

	byte[] addressCardPicture
	
	Boolean certified
	
	@Formula("0")
	private int dummyFieldForHibernateNotNullEmbedded;
}
