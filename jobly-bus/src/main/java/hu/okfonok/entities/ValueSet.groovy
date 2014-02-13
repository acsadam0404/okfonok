package hu.okfonok.entities

import javax.persistence.CollectionTable
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull


/**
 * 
 * @author Ács Ádám
 *
 */
@Entity
@Table(name = "ValueSet")
class ValueSet extends BaseEntity {
	@Column
	@NotNull
	String name

	@Column
	@NotNull
	String valuesString
	
	List<String> getValues() {
		valuesString.tokenize("|||") 
	}
}
