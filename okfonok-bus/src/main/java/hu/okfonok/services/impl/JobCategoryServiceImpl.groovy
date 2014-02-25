package hu.okfonok.services.impl

import hu.okfonok.dao.JobCategoryDao
import hu.okfonok.entities.JobCategory
import hu.okfonok.services.JobCategoryService

import javax.inject.Inject
import javax.inject.Named
import javax.persistence.TypedQuery

import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("jobCategoryService")
@Transactional
class JobCategoryServiceImpl extends BaseServiceImpl<JobCategory> implements JobCategoryService{
	@Inject
	private JobCategoryDao dao;
	
	@Override
	public List<JobCategory> findSubsByMain(long mainId) {
		dao.findSubsByMain(mainId)	
	}
	
	@Override
	List<JobCategory> findAll() {
		dao.findAll()
	}	
	
	@Override
	List<JobCategory> findAllMain() {
		dao.findAllMain()
	}
	
	@Override
	public JobCategory findByName(String name) {
		dao.findByName(name)
	}
	
}
