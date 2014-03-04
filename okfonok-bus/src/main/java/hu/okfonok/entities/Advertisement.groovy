package hu.okfonok.entities;

import javax.persistence.ElementCollection
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.validation.constraints.Size

@Entity
class Advertisement extends BaseEntity{
	String name
	@Size(max = 2000)
	String description
	
	String remuneration
	
	@ElementCollection(targetClass = String.class)
	List<String> imagePaths = new ArrayList<String>()
	
	JobCategory mainCategory
	
	JobCategory subCategory
	
	@Embedded
	Address address = new Address()
	
	boolean specifiedJobTime
	
	Date jobTime
	
	Date expiration
}


