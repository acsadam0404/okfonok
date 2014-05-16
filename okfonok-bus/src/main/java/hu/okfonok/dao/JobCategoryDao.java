package hu.okfonok.dao;

import hu.okfonok.entities.JobCategory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobCategoryDao extends JpaRepository<JobCategory, Long> {
	@Query("select jc from JobCategory jc where jc.main = 1")
	List<JobCategory> findAllMain();

	JobCategory findByName(String name);
}
