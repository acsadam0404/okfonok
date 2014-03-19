package hu.okfonok.dao.impl

import hu.okfonok.dao.JobCategoryDao
import hu.okfonok.entities.JobCategory

import javax.inject.Named
import javax.persistence.TypedQuery


@Named
class JobCategoryDaoImpl extends BaseDaoImpl<JobCategory> implements JobCategoryDao{
	@Override
	public List<JobCategory> findSubsByMain(long mainId) {
		JobCategory main = find(JobCategory.class, mainId)
		return main.subCategories
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
