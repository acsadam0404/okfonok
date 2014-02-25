package hu.okfonok.dao.impl

import hu.okfonok.dao.ValueStoreDao
import hu.okfonok.entities.ValueStore

import javax.inject.Named
import javax.persistence.TypedQuery

@Named
class ValueStoreDaoImpl extends BaseDaoImpl<ValueStore> implements ValueStoreDao{
	
	@Override
	public String getValue(String storeName) {
		TypedQuery<ValueStore> query = em.createQuery("from ValueStore where name = '${storeName}'", ValueStore.class)
		return query.getSingleResult().getValue()
	}
}
