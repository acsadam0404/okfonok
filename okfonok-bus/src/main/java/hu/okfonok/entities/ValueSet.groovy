package hu.okfonok.entities

import groovy.transform.EqualsAndHashCode;

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull


@Entity
@Table(name = 'valueset')
@EqualsAndHashCode(includes = ['name'])
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
	

}
