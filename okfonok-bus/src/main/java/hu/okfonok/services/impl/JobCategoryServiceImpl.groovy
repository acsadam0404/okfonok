package hu.okfonok.services.impl

import hu.okfonok.dao.JobCategoryDao
import hu.okfonok.entities.JobCategory
import hu.okfonok.services.JobCategoryService

import javax.inject.Named

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("jobCategoryService")
@Transactional
class JobCategoryServiceImpl extends BaseServiceImpl<JobCategory> implements JobCategoryService{
	@Autowired
	private transient JobCategoryDao repo
	
	@Autowired
	JobCategoryServiceImpl(JobCategoryDao crudRepo) {
		super(crudRepo);
	}
	
	
	@Override
	List<JobCategory> findSubsByMain(long mainId) {
		repo.findOne(mainId).subCategories	
	}
	
	@Override
	List<JobCategory> findAll() {
		repo.findAll()
	}	
	
	@Override
	List<JobCategory> findAllMain() {
		repo.findAllMain()
	}
	
	@Override
	JobCategory findByName(String name) {
		repo.findByName(name)
	}
}
