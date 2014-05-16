package hu.okfonok.dao;

import java.util.List;

import hu.okfonok.entities.ValueSet;

public interface ValueSetDao extends BaseDao<ValueSet> {
	List<String> getValues(String valueSetName);
}
