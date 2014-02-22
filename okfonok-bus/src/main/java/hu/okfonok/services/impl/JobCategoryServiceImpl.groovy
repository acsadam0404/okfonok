package hu.okfonok.services.impl

import hu.okfonok.entities.JobCategory
import hu.okfonok.services.JobCategoryService

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
	@Override
	public List<JobCategory> findSubsByMain(long mainId) {
		JobCategory main = find(JobCategory.class, mainId)
		return main.subCategories
	}
	
	@Override
	List<JobCategory> findAll() {
		TypedQuery<JobCategory> query = em.createQuery("select jc from JobCategory jc", JobCategory.class)
		return query.resultList
	}	
	
	@Override
	List<JobCategory> findAllMain() {
		TypedQuery<JobCategory> query = em.createQuery("select jc from JobCategory jc where jc.main = 1", JobCategory.class)
		return query.resultList
	}
	
	@Override
	public JobCategory findByName(String name) {
		TypedQuery<JobCategory> query = em.createQuery("select jc from JobCategory jc  where jc.name = '$name'", JobCategory.class)
		return query.singleResult
	}
	
}
