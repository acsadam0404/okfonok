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
	T save(T t);
	
	List<T> findAll();
}
