package hu.okfonok.dao;

import java.io.Serializable;

public interface BaseDao<T> extends Serializable {
	T persist(T t);

	void remove(long id);

	void remove(T t);

	T find(Class<T> tclazz, long id);
	
	T merge(T t);
}
