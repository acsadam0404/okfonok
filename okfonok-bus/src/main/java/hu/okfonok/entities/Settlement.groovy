package hu.okfonok.entities

import groovy.transform.EqualsAndHashCode;

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * 
 * @author Ács Ádám
 *
 */
@Entity
@Table(name= "settlement")
@EqualsAndHashCode
class Settlement extends BaseEntity {
	Integer zip
	
	String settlement
}
