package hu.okfonok.beans;

import hu.okfonok.entities.Skill
import hu.okfonok.entities.user.User
import hu.okfonok.entities.user.UserSkill
import hu.okfonok.services.SkillService;
import hu.okfonok.services.UserService
import hu.okfonok.utils.ServiceLocator

import org.primefaces.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("ownSkillsBean")
@Scope("session")
class OwnSkillsBean {
	
	@Autowired
	private SkillService skillService
	
	boolean dialogAlreadyOpened
	
	@Autowired
	private UserBean userBean
	 
	User getUser() {
		return userBean.user
	}
	List<Skill> skills
	
	Map<Skill, Integer> ratings = [:]
	 
	List<Skill> getRandomSkills() {
		def skills = findNewSkills()
		/* ha nem üres és még nem dobtuk fel akkor feldobjuk a dialógust */
		if (!dialogAlreadyOpened && !skills.empty) {
			dialogAlreadyOpened = true
			RequestContext.currentInstance.execute("PF('dlgFillskills').show();")
		}
		return skills
	}
	
	List<Skill> findNewSkills() {
		skills = skillService.findRandom(getUser(), 4)
		ratings.clear()
		skills.each {
			ratings[it] = 0
		}
	}
	
	def finish() {
		save()
		RequestContext.currentInstance.execute("PF('dlgFillskills').hide()")
	}
	
	def next() {
		save()
		skills = skillService.findRandom(getUser(), 4)
		if (skills.empty){
			RequestContext.currentInstance.execute("PF('dlgFillskills').hide()")
		} 
	}
	
	def save() {
		skills.each {
			getUser().skills << new UserSkill(skill: it, ownRating: ratings.get(it))
		}
		ServiceLocator.getBean(UserService).save(getUser())
	}
}
