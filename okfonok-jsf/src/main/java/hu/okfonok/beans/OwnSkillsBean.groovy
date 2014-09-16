package hu.okfonok.beans;

import hu.okfonok.entities.Skill
import hu.okfonok.entities.user.User

import org.primefaces.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("ownSkillsBean")
@Scope("session")
class OwnSkillsBean extends SkillsBean{
	
	boolean dialogAlreadyOpened
	
	@Autowired
	private UserBean userBean
	
	@Override
	User getUser() {
		return userBean.user
	}
	
	
	/* TODO erre külön bean kell */
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
