package hu.okfonok.entities.data

import hu.okfonok.entities.BaseEntity;

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
