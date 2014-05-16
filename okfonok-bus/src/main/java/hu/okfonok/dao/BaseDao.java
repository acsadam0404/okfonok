package hu.okfonok.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> extends Serializable {
	T persist(T t);

	void remove(long id);

	void remove(T t);

	T find(Class<T> tclazz, long id);
	
	T merge(T t);
	
	List<T> findAll(Class<T> klass);
}
