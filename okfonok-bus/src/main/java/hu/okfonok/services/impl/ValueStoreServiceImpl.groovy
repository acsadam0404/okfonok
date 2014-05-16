package hu.okfonok.services.impl

import hu.okfonok.dao.ValueStoreDao
import hu.okfonok.entities.ValueStore
import hu.okfonok.services.ValueStoreService

import javax.inject.Named

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

/**
 *
 * @author Ács Ádám
 *
 */
@Named("valueStoreService")
@Transactional
class ValueStoreServiceImpl extends BaseServiceImpl<ValueStore> implements ValueStoreService  {
	@Autowired
	private transient ValueStoreDao repo;
	
	@Autowired
	ValueStoreServiceImpl(ValueStoreDao crudRepo) {
		super(crudRepo);
	}
	
	@Override
	String getValue(String storeName) {
		repo.getValue(storeName)
	}
}
