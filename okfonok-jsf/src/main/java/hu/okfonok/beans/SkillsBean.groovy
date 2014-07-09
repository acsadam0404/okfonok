package hu.okfonok.beans;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("skillsBean")
@Scope("session")
class SkillsBean {
	
	@Autowired
	private UserBean userBean
	
	String getNames() {
		List names = userBean.user.skills.collect() {
			"'" + it.name + "'"
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
}
