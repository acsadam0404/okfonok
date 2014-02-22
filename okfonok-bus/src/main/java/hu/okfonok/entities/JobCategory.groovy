package hu.okfonok.entities

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

/**
 * 
 * @author Ács Ádám
 *
 */
@Entity
class JobCategory extends BaseEntity{
	boolean main

	@OneToMany(mappedBy="mainCategory", fetch=FetchType.EAGER)
	List<JobCategory> subCategories

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="main_id")
	JobCategory mainCategory

	String name
	
	@Override
	public String toString() {
		return name;
	}
}
