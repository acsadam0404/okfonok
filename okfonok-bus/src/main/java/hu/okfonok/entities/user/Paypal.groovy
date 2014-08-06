package hu.okfonok.entities.user

import groovy.transform.EqualsAndHashCode;

import javax.persistence.Embeddable

import org.hibernate.annotations.Formula

@Embeddable
@EqualsAndHashCode
class Paypal implements Serializable {
	String accountName
	
	@Formula("0")
	private int dummyFieldForHibernateNotNullEmbedded;
}
