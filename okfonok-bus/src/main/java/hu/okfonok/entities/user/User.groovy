package hu.okfonok.entities.user

import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;
import hu.okfonok.entities.Address
import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.BaseEntity
import hu.okfonok.entities.Role

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

import org.hibernate.annotations.Formula;

/**
 * 
 * @author Ács Ádám
 *
 */
@Entity
@Table(name = 'user')
@EqualsAndHashCode
@ToString
class User extends BaseEntity implements Serializable{

	@Column(unique = true)
	@NotNull
	@Size(min=4, max=60)
	String userName

	@NotNull
	@Size(min=4)
	String password

	Boolean enabled = false

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "User_Roles", joinColumns = [ @JoinColumn(name = "user_id", referencedColumnName="id") ], inverseJoinColumns = [ @JoinColumn(name = "role_id", referencedColumnName="id") ])
	Set<Role> roles = new HashSet<>()

	@Embedded
	Address address = new Address()

	@Embedded
	Certification certification = new Certification()

	@Embedded
	Profile profile = new Profile()

	String providerId

	@Embedded
	Paypal paypal

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "user_userskills", joinColumns = [ @JoinColumn(name = "user_id", referencedColumnName="id") ], inverseJoinColumns = [ @JoinColumn(name = "userskill_id", referencedColumnName="id") ])
	Set<UserSkill> skills = new HashSet<>()
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "user_points", joinColumns = [ @JoinColumn(name = "user_id", referencedColumnName="id") ], inverseJoinColumns = [ @JoinColumn(name = "point_id", referencedColumnName="id") ])
	Set<Point> points = new HashSet<>()
	
	@OneToMany(orphanRemoval=true ,cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "user_savedAds", joinColumns = [ @JoinColumn(name = "user_id", referencedColumnName="id") ], inverseJoinColumns = [ @JoinColumn(name = "ad_id", referencedColumnName="id") ])
	Set<Advertisement> savedAds = new HashSet<>()
	
	Integer balance = 0
	
	Integer loginCount = 0
}
