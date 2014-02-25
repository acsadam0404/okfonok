package hu.okfonok.services.impl

import hu.okfonok.dao.ValueStoreDao
import hu.okfonok.entities.ValueStore
import hu.okfonok.services.ValueStoreService

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 *
 * @author Ács Ádám
 *
 */
@Named("valueStoreService")
@Transactional
class ValueStoreServiceImpl extends BaseServiceImpl<ValueStore> implements ValueStoreService  {
	@Inject
	private ValueStoreDao dao;
	
	@Override
	public String getValue(String storeName) {
		dao.getValue(storeName)
	}
	
}
