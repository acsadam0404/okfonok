package hu.jobly.services;

import java.util.List;

/**
 * 
 * @author Ács Ádám
 * 
 * @param <T>
 */
public interface BaseService<T> {
	T create(T t);

	void delete(long id);

	void delete(T t);

	T find(Class<T> tclazz, long id);

	T save(T t);

	List<T> findAll(Class<T> tclazz);

	List<T> findAll();
}
