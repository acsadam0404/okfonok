package hu.okfonok.entities.user

import groovy.transform.EqualsAndHashCode
import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.BaseEntity;

import javax.persistence.Entity
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name ="transaction")
@EqualsAndHashCode
class Transaction extends BaseEntity {
	@OneToOne
	Advertisement ad
	
	User fromUser
	
	User toUser
	
	Date datum
	
	int net
	
	int gross
	
	int getServicePrice() {
		return gross - net
	}
}
