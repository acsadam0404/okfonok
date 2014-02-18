package hu.okfonok.services;

import java.util.List;

import hu.okfonok.entities.ValueSet;

/**
 * 
 * @author Ács Ádám
 *
 */
public interface ValueSetService extends BaseService<ValueSet>{
	List<String> getValues(String valueSetName);
}
