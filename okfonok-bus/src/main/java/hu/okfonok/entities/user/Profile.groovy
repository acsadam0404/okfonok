package hu.okfonok.entities.user

import groovy.transform.EqualsAndHashCode;

import javax.persistence.CascadeType
import javax.persistence.Embeddable
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

import org.hibernate.annotations.Formula

/**
 * 
 * @author Ács Ádám
 *
 */
@Embeddable
@EqualsAndHashCode
class Profile implements Serializable {

	String profileImagePath

	@Size(max = 1000)
	String introduction

	@Size(min=1, max = 100)
	@NotNull
	String lastName

	@Size(min=1, max=100)
	@NotNull
	String firstName

	@Size(min = 4)
	String email
	
	/* maskedinput validálja */	
	String phoneNumber

	Boolean employer

	Boolean employee

	Boolean personalEmployer

	Boolean companyEmployer

	String facebookValidatedId
	
	Boolean working

	@Formula("0")
	private int dummyFieldForHibernateNotNullEmbedded;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "User_Ratings", joinColumns = [ @JoinColumn(name = "user_id", referencedColumnName="id") ], inverseJoinColumns = [ @JoinColumn(name = "rating_id", referencedColumnName="id") ])
	Set<Rating> ratings = new HashSet<Rating>()
	
	Integer getRating() {
		if (ratings.empty) {
			return null
		}
		
		double sum = 0
		for (r in ratings) {
			sum += r.val
		}
		
		return Math.round(sum / ratings.size())
	}
		
	/**
	 * N. Árpád
	 * @return
	 */
	String getRealNameAbbr() {
		return lastName[0] + ". " + firstName
	}
	
	/**
	 * Nárasi Árpád
	 * @return
	 */
	@NotNull
	String getRealName() {
		if (!lastName || !firstName) {
			return null
		}
		return lastName+ " " + firstName
	}
	
	void setRealName(String realName) {
		if (realName && realName.contains(" ")) {
			String[] split = realName.split(" ")
			lastName = split[0]
			firstName = realName - split[0]	
		}
	}
}
