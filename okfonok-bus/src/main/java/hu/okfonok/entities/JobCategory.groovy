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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobCategory other = (JobCategory) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
