package hu.okfonok.services;

import java.io.Serializable;


/**
 * 
 * @author Ács Ádám
 * 
 * @param <T>
 */
public interface BaseService<T> extends Serializable {
	T save(T t);
}
