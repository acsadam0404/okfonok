package hu.okfonok.services;

import hu.okfonok.entities.user.Point;

import java.util.List;

public interface PointService {
	
	List<Point> findLast5();

	Point findLast();

	void add(int sum);

	void subtract(int sum);
	
}
