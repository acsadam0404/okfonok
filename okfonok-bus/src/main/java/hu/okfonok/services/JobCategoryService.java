package hu.okfonok.services;

import hu.okfonok.entities.JobCategory;

import java.util.List;

/**
 * 
 * @author Ács Ádám
 *
 */
public interface JobCategoryService extends BaseService<JobCategory> {
	List<JobCategory> findSubsByMain(long mainId);
	
	List<JobCategory> findAllMain();
	
	JobCategory findByName(String name);
	
	List<JobCategory> findAll();
}
