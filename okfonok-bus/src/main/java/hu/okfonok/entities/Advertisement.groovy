package hu.okfonok.entities;

import hu.okfonok.entities.user.User

import javax.persistence.ElementCollection
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
class Advertisement extends BaseEntity{
	@ManyToOne
	@NotNull
	User user
	
	@Size(max = 2000)
	@NotNull
	String description
	
	@NotNull
	String remuneration
	
	@ElementCollection(targetClass = String.class)
	List<String> imagePaths = new ArrayList<String>()
	
	@ManyToOne
	@NotNull
	JobCategory category
	
	@Embedded
	Address address = new Address()
	
	boolean specifiedJobTime
	
	Date jobTime
	
	Date expiration
	
	Integer maxOffer
	
	boolean homework
}


