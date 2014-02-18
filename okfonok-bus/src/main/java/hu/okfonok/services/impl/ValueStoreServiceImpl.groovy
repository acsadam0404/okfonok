package hu.okfonok.services.impl

import hu.okfonok.entities.ValueStore
import hu.okfonok.services.ValueStoreService

import javax.inject.Named
import javax.persistence.TypedQuery

import org.springframework.transaction.annotation.Transactional

/**
 *
 * @author Ács Ádám
 *
 */
@Named("valueStoreService")
@Transactional
class ValueStoreServiceImpl extends BaseServiceImpl<ValueStore> implements ValueStoreService  {

	@Override
	public String getValue(String storeName) {
		TypedQuery<ValueStore> query = em.createQuery("from ValueStore where name = '${storeName}'", ValueStore.class)
		return query.getSingleResult().getValue()
	}
	
}
