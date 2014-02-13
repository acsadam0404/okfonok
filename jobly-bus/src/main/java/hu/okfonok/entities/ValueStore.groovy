package hu.okfonok.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

/**
 *
 * @author Ács Ádám
 *
 */
@Entity
@Table(name = "ValueStore")
class ValueStore extends BaseEntity  {
	@Column
	@NotNull
	String name
	
	@Column
	@NotNull
	String value
}
