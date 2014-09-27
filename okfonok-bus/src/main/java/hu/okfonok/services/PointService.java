package hu.okfonok.services;

import hu.okfonok.entities.user.Point;
import hu.okfonok.entities.user.User;

import java.util.List;

public interface PointService {
	
	List<Point> findLast5();

	List<Point> findLast5(User user);
	
	Point findLast();
	
	Point findLast(User user);

	void add(int sum);

	void subtract(int sum);
	
}
