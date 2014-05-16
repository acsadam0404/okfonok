package hu.okfonok.services;

import java.util.List;
import java.util.Set;

import hu.okfonok.entities.ValueSet;

/**
 * TODO közös kód
 * @author Ács Ádám
 *
 */
public interface ValueSetService extends BaseService<ValueSet>{
	List<String> findValuesByName(String name);

	Set<String> findValuesByNameUnique(String name);
}
