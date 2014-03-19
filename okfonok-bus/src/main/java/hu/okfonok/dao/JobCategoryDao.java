package hu.okfonok.dao;

import java.util.List;

import hu.okfonok.entities.JobCategory;

public interface JobCategoryDao extends BaseDao<JobCategory> {
	List<JobCategory> findSubsByMain(long mainId);

	List<JobCategory> findAllMain();

	JobCategory findByName(String name);
}
