package hu.okfonok.services.impl

import hu.okfonok.dao.BaseDao
import hu.okfonok.dao.JobCategoryDao
import hu.okfonok.entities.JobCategory
import hu.okfonok.services.JobCategoryService
import hu.okfonok.utils.ServiceLocator

import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("jobCategoryService")
@Transactional
class JobCategoryServiceImpl extends BaseServiceImpl<JobCategory> implements JobCategoryService{
	@Override
	public List<JobCategory> findSubsByMain(long mainId) {
		getDao().findSubsByMain(mainId)	
	}
	
	@Override
	List<JobCategory> findAll() {
		getDao().findAll()
	}	
	
	@Override
	List<JobCategory> findAllMain() {
		getDao().findAllMain()
	}
	
	@Override
	public JobCategory findByName(String name) {
		getDao().findByName(name)
	}

	@Override
	public BaseDao<JobCategory> getDao() {
		return ServiceLocator.getBean(JobCategoryDao.class);
	}
	
}
