package hu.jobly.services;

import java.util.List;

import hu.jobly.entities.ValueSet;

/**
 * 
 * @author Ács Ádám
 *
 */
public interface ValueSetService extends BaseService<ValueSet>{
	List<String> getValues(String valueSetName);
	
	List<String> getHelpCategories();
}
