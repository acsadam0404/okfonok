package hu.okfonok.beans;

import hu.okfonok.entities.Skill
import hu.okfonok.entities.user.User
import hu.okfonok.services.SkillService

import org.primefaces.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("skillsBean")
@Scope("session")
class SkillsBean {
	
	@Autowired
	protected SkillService skillService
	
	User user
	
	String getNames() {
		List names = getUser().skills.collect() {
			"'" + it.skill.name + "'"
		}
		return names.join(',')
	}
	
	String getOwnRatings() {
		List ratings = getUser().skills.collect() {
			it.ownRating
		}
		return ratings.join(',')
	}
	
	String getRatings() {
		List ratings = getUser().skills.collect() {
			it.rating
		}
		return ratings.join(',')
	}
}
