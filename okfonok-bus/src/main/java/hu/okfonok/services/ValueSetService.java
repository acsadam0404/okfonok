package hu.okfonok.services;

import hu.okfonok.entities.ValueSet;
import hu.okfonok.entities.ValueSetEntry;

import java.util.List;
import java.util.Set;

/**
 * TODO közös kód
 * @author Ács Ádám
 *
 */
public interface ValueSetService extends BaseService<ValueSet>{
	List<ValueSetEntry> findByName(String name);

	Set<ValueSetEntry> findByNameUnique(String name);
}
