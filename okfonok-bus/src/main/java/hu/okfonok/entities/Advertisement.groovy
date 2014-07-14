package hu.okfonok.entities;

import hu.okfonok.entities.user.User

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Transient
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((expiration == null) ? 0 : expiration.hashCode());
		result = prime * result + ((jobTime == null) ? 0 : jobTime.hashCode());
		result = prime * result + (specifiedJobTime ? 1231 : 1237);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Advertisement other = (Advertisement) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expiration == null) {
			if (other.expiration != null)
				return false;
		} else if (!expiration.equals(other.expiration))
			return false;
		if (jobTime == null) {
			if (other.jobTime != null)
				return false;
		} else if (!jobTime.equals(other.jobTime))
			return false;
		if (specifiedJobTime != other.specifiedJobTime)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
}


