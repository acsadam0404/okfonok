package hu.okfonok.dao.impl

import hu.okfonok.dao.BaseDao

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.PersistenceContextType

import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional(propagation = Propagation.MANDATORY)
class BaseDaoImpl<T> implements BaseDao<T> {
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
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