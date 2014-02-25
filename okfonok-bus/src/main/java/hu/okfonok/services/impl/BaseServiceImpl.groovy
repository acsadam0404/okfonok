package hu.okfonok.services.impl;

import hu.okfonok.services.BaseService

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

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
				return dao.persist(t);
			}
			else {
				return dao.merge(t);
			}
		}
	}
}
