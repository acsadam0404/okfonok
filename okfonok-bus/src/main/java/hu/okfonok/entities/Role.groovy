package hu.okfonok.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Ács Ádám
 *
 */
@Entity
@Table(name = "Role")
class Role extends BaseEntity {
	
	@Column
	@NotNull
	String name
}
