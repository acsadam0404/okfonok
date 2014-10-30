package hu.okfonok.entities;

import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
@ToString
@EqualsAndHashCode(includes=["name", "skillGroup"])
class Skill extends BaseEntity {
	String name
	
	String question
	
	String skillGroup
}
