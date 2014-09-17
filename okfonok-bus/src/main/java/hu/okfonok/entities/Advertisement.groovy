package hu.okfonok.entities;

import groovy.transform.EqualsAndHashCode
import hu.okfonok.entities.user.User
import hu.okfonok.types.DateInterval

import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
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

	@Transient
	private transient List<DateInterval> preferredTimes

	@Column(columnDefinition = "TEXT")
	String preferredTimesString

	@OneToMany(mappedBy = "ad", fetch = FetchType.EAGER)
	Collection<Offer> offers = []

	List<String> getImagePaths() {
		if (imagePathsString) {
			imagePathsString.split("|")
		}
		/* 5 elemű nullokból álló lista */
		return [null,null,null,	null,null]
	}

	void setImagePaths(List<String> imagePaths) {
		if (imagePaths && !imagePaths.empty) {
			imagePathsString = imagePaths.collect { it + "|" }
			imagePathsString -= '|'
		}
	}

	void setPreferredTimes(List<DateInterval> intervals) {
		if (intervals && !intervals.empty) {
			preferredTimesString = intervals.collect {
				it.toString() + "|"
			}
			preferredTimesString -= '|'
		}
	}

	List<DateInterval> getPreferredTimes() {
		def intervals = []
		if (preferredTimesString) {
			preferredTimesString.split("|")?.each { item ->
				intervals << DateInterval.parse(item)
			}
		}
		return intervals
	}
}
