package hu.okfonok.entities.user

import groovy.transform.EqualsAndHashCode
import hu.okfonok.entities.BaseEntity

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "notification")
@EqualsAndHashCode
class Notification extends BaseEntity implements Comparable<Notification>{
	@NotNull
	@ManyToOne
	User user

	@NotNull
	String message

	String actionLink
	
	boolean isRead
	
	Date datum

	@Override
	public int compareTo(Notification o) {
		return datum <=> o.datum 
	}
}
