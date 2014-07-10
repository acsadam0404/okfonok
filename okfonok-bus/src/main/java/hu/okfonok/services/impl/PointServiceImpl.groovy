package hu.okfonok.services.impl;

import hu.okfonok.dao.PointDao
import hu.okfonok.entities.user.Point
import hu.okfonok.services.PointService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service("pointService")
@Transactional
class PointServiceImpl implements PointService {
	
	@Autowired
	private PointDao dao

	@Override
	List<Point> findLast5() {
		dao.findLast5()
	}

	@Override
	Point findLast() {
//	dao.findLast() //TODO
		return new Point(sum: 15)
	}

	void add(int sum) {
		Point last = findLast()
		Point newPoint = new Point(datum: new Date(), sum: last.sum + sum)
		dao.save(newPoint)
	}

	void subtract(int sum) {
		Point last = findLast()
		Point newPoint = new Point(datum: new Date(), sum: last.sum - sum)
		dao.save(newPoint)
	}
	
}
