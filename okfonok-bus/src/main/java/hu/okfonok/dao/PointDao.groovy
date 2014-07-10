package hu.okfonok.dao;

import hu.okfonok.entities.user.Point;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface PointDao extends JpaRepository<Point, Long>{
	/*TODO user specifikusan */
	@Query("select p from Point p order by datum desc")
	List<Point> findLast5();
	
	/*TODO user specifikusan és csak egyet adjon vissza*/
	@Query("select p from Point p order by datum desc")
	Point findLast();
}
