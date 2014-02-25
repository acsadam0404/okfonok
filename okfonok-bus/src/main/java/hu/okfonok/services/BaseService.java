package hu.okfonok.services;


/**
 * 
 * @author Ács Ádám
 * 
 * @param <T>
 */
public interface BaseService<T> {
	T save(T t);
}
