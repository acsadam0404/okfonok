package hu.okfonok.beans;

import hu.okfonok.entities.Skill
import hu.okfonok.services.SkillService

import org.primefaces.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("skillsBean")
@Scope("session")
class SkillsBean {
	
	@Autowired
	private UserBean userBean
	
	@Autowired
	private SkillService skillService
	
	boolean dialogAlreadyOpened
	
	String getNames() {
		List names = userBean.user.skills.collect() {
			"'" + it.skill.name + "'"
		}
		return names.join(',')
	}
	
	String getOwnRatings() {
		List ratings = userBean.user.skills.collect() {
			it.ownRating
		}
		return ratings.join(',')
	}
	
	String getRatings() {
		List ratings = userBean.user.skills.collect() {
			it.rating
		}
		return ratings.join(',')
	}
	
	/* TODO */
	List<Skill> getRandomQuestions() {
		List<Skill> questions = skillService.findAll()
		/* ha nem üres és még nem dobtuk fel akkor feldobjuk a dialógust */
		if (!dialogAlreadyOpened && !questions.empty) {
			dialogAlreadyOpened = true
			RequestContext.currentInstance.execute("PF('dlgFillskills').show();")
		}
		return questions
	}
}
