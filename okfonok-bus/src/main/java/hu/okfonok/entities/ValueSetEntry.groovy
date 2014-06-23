package hu.okfonok.entities;

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name =  "ValueSetEntry")
class ValueSetEntry extends BaseEntity{
	
	@NotNull
	String key

	@NotNull
	@ManyToOne
	ValueSet valueSet
	
	//TODO
	String getValue() {
		return 'i18n-es ' + key
	}
	
	@Override
	public String toString() {
		return getValue()
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result
				+ ((valueSet == null) ? 0 : valueSet.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueSetEntry other = (ValueSetEntry) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (valueSet == null) {
			if (other.valueSet != null)
				return false;
		} else if (!valueSet.equals(other.valueSet))
			return false;
		return true;
	}
}
