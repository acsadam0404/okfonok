package hu.okfonok.services.impl

import hu.okfonok.dao.SkillDao
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
	List<String> findAll() {
		dao.findAll()
	}

}
