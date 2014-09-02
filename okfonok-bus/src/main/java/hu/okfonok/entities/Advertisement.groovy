package hu.okfonok.entities;

import groovy.transform.EqualsAndHashCode
import hu.okfonok.entities.user.User

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Transient
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = 'advertisement')
@EqualsAndHashCode
class Advertisement extends BaseEntity{
	@ManyToOne
	@NotNull
	User user
	
	@Size(max = 2000)
	@NotNull
	String description
	
	@NotNull
	String remuneration
	
	String imagePathsString
	
	@Transient
	private transient List<String> imagePaths
	
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

	List<String> getImagePaths() {
		if (imagePathsString != null) {
			imagePathsString.split("|")
		}
		/* 5 elemű nullokból álló lista */
		return [null, null, null, null, null] 
	}
	
	void setImagePaths(List<String> imagePaths) {
		if (imagePaths && !imagePaths.empty) {
			imagePathsString = imagePaths.collect {
				it + "|"
			}
			imagePathsString -= '|'
		}
	}
	
}
