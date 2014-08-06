package hu.okfonok.entities.user

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import hu.okfonok.entities.BaseEntity;
import hu.okfonok.entities.Skill

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "userskill")
@ToString
@EqualsAndHashCode
class UserSkill extends BaseEntity {
	@ManyToOne
	Skill skill
	
	int rating
	
	int ownRating
}
