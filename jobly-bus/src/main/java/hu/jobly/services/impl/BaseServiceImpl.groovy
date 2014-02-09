package hu.jobly.services.impl;

import hu.jobly.services.BaseService

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
abstract class BaseServiceImpl<T> implements BaseService<T> {
	@PersistenceContext
	protected final EntityManager em;


	T persist(T t) {
		if (t) {
			em.persist(t)
		}
		return t
	}

	void remove(T t) {
		if (t) {
			em.remove(t)
		}
	}

	void remove(long id) {
		em.remove(find(id))
	}

	T find(Class<T> tclazz, long id) {
		return (T) em.find(tclazz, id)
	}
	
	T merge(T t) {
		if (t) {
			em.merge(t)
		}
		return t
	}
}
