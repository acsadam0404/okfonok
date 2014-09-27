package hu.okfonok.dao;

import hu.okfonok.entities.user.Point
import hu.okfonok.entities.user.User

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PointDao extends JpaRepository<Point, Long>{
	/*TODO user specifikusan */
	@Query("select p from Point p order by datum desc")
	List<Point> findLast5();
	
	@Query("select points from User u where u.userName = :userName order by datum desc")
	List<Point> findLast5(@Param("userName") String userName);
	
	/*TODO user specifikusan és csak egyet adjon vissza*/
	@Query("select p from Point p order by datum desc")
	Point findLast();
}
