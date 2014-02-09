package hu.jobly.services;


/**
 * 
 * @author Ács Ádám
 * 
 * @param <T>
 */
public interface BaseService<T> {
	T persist(T t);

	void remove(long id);

	void remove(T t);

	T find(Class<T> tclazz, long id);
	
	T merge(T t);
}
