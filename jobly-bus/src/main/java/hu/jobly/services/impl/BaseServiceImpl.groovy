package hu.jobly.services.impl;

import hu.jobly.services.BaseService;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Ács Ádám
 *
 * @param <T>
 */
@Transactional
abstract class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	private SessionFactory sessionFactory


	protected Session currentSession() {
		sessionFactory.getCurrentSession()
	}

	T create(T t) {
		if (t) {
			currentSession().persist(t)
		}
		return t
	}

	void delete(T t) {
		if (t) {
			currentSession().delete(t)
		}
	}

	void delete(long id) {
		currentSession().delete(find(id))
	}

	T find(Class<T> tclazz, long id) {
		return (T) currentSession().get(tclazz, id)
	}

	T save(T t) {
		currentSession().update(t)
	}

	List<T> findAll(Class<T> tclazz) {
		currentSession().createCriteria(tclazz).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
}
