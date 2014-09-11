package hu.okfonok.entities;

import groovy.transform.EqualsAndHashCode
import hu.okfonok.entities.user.User

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "offer")
@EqualsAndHashCode
class Offer extends BaseEntity{
	@ManyToOne
	Advertisement ad
	
	@ManyToOne
	User user
	
	Integer offer
}
