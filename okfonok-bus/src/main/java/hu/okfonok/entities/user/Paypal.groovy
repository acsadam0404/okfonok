package hu.okfonok.entities.user

import javax.persistence.Embeddable

import org.hibernate.annotations.Formula

@Embeddable
class Paypal {
	String accountName
	
	@Formula("0")
	private int dummyFieldForHibernateNotNullEmbedded;
}
