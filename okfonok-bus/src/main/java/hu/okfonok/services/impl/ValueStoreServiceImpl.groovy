package hu.okfonok.services.impl

import hu.okfonok.dao.BaseDao
import hu.okfonok.dao.ValueStoreDao
import hu.okfonok.entities.ValueStore
import hu.okfonok.services.ValueStoreService
import hu.okfonok.utils.ServiceLocator

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
	@Override
	public String getValue(String storeName) {
		getDao().getValue(storeName)
	}

	@Override
	public BaseDao<ValueStore> getDao() {
		return ServiceLocator.getBean(ValueStoreDao.class);
	}
	
}
