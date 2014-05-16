package hu.okfonok.services.impl;

import hu.okfonok.dao.BaseDao
import hu.okfonok.services.BaseService

import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 * @param <T>
 */
@Transactional(propagation = Propagation.REQUIRED)
abstract class BaseServiceImpl<T> implements BaseService<T>, Serializable {
	@Transactional
	@Override
	T save(T t) {
		if (t) {
			if (!t.id) {
				return getDao().persist(t);
			}
			else {
				return getDao().merge(t);
			}
		}
	}
	
	abstract BaseDao<T> getDao();
	
	List<T> findAll() {
		throw new UnsupportedOperationException()
	}
}
