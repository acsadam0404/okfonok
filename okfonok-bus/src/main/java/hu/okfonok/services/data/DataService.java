package hu.okfonok.services.data;

import java.util.List;

/**
 * 
 * @author Ács Ádám
 *
 * @param <T>
 */
public interface DataService<T> {
	List<T> findAll();
}
