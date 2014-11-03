package hu.okfonok.services.impl

import hu.okfonok.dao.SkillDao
import hu.okfonok.entities.Skill
import hu.okfonok.entities.user.User
import hu.okfonok.services.SkillService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service("skillService")
@Scope("singleton")
@Transactional
class SkillServiceImpl implements SkillService {
	@Autowired
	private SkillDao dao
	
	@Override
	List<Skill> findAll() {
		dao.findAll()
	}
	
	List<Skill> findRandom(User user, int count) {
		List<Skill> newSkills = findAll()
		def userSkills = user.skills?.collect() { it.skill}
		newSkills.removeAll(userSkills)
		List<Skill> randomSkills = []
		if (newSkills && !newSkills.empty) {
			for (int i = 0; i < count && i < newSkills.size(); i++) {
				randomSkills << newSkills[i]
			}
		}
		return randomSkills
	}

}
