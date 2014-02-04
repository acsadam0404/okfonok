package hu.jobly.entities

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * 
 * @author Ács Ádám
 *
 */
@Entity
@Table(name = "User")
class User extends BaseEntity {
	
	@Column(unique = true)
	@NotNull
	@Size(min=4, max=20)
	String userName
	
	@Column
	@NotNull
	@Size(min=4)
	String password
	
	@Column
	Boolean enabled = true
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "User_Roles", joinColumns = [ @JoinColumn(name = "user_id", referencedColumnName="id") ], inverseJoinColumns = [ @JoinColumn(name = "role_id", referencedColumnName="id") ])
	Set<Role> roles = new HashSet<Role>()
	
}
