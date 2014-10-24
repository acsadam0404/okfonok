package hu.okfonok.entities;

import groovy.transform.EqualsAndHashCode;

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name =  "valuesetentry")
@EqualsAndHashCode
class ValueSetEntry extends BaseEntity{
	
	@NotNull
	String bkey

	@NotNull
	@ManyToOne
	ValueSet valueSet
	
	//TODO
	String getValue() {
		return 'i18n-es ' + bkey
	}
	
	@Override
	public String toString() {
		return getValue()
	}
}
