package hu.okfonok.dao;

import hu.okfonok.entities.ValueStore;

public interface ValueStoreDao extends BaseDao<ValueStore>{
	String getValue(String storeName);
}
