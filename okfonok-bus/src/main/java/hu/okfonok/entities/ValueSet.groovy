package hu.okfonok.entities

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull


@Entity
@Table(name = 'ValueSet')
class ValueSet extends BaseEntity {

	@NotNull
	String name

	@NotNull
	@OneToMany(mappedBy = 'valueSet', fetch = FetchType.EAGER)
	List<ValueSetEntry> entries

	@Override
	String toString() {
		return 'ValueSet: ' + name
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
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueSet other = (ValueSet) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
