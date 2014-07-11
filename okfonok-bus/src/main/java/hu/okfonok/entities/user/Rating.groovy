package hu.okfonok.entities.user;

import groovy.transform.EqualsAndHashCode
import hu.okfonok.entities.BaseEntity

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
@Table(name = "Rating")
@EqualsAndHashCode
class Rating extends BaseEntity {
	
	@ManyToOne
	User rater
	
	@Min(1l)
	@Max(5l)
	int val
	
	String description

}
