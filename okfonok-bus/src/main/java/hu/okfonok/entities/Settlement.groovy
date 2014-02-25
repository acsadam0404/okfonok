package hu.okfonok.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * 
 * @author Ács Ádám
 *
 */
@Table(name= "settlement")
@Entity
class Settlement extends BaseEntity {
	Integer zip
	
	String settlement
}
