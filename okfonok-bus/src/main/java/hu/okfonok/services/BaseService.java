package hu.okfonok.services;

import java.io.Serializable;
import java.util.List;


/**
 * 
 * @author Ács Ádám
 * 
 * @param <T>
 */
public interface BaseService<T> extends Serializable {
	void save(T t);
	
	void delete(T t);

	List<T> findAll();
	
	T find(long id);
}
