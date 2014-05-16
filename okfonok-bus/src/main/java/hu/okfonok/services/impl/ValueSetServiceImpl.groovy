package hu.okfonok.services.impl

import hu.okfonok.dao.BaseDao
import hu.okfonok.dao.ValueSetDao
import hu.okfonok.entities.ValueSet
import hu.okfonok.services.ValueSetService
import hu.okfonok.utils.ServiceLocator

import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 *
 * @author Ács Ádám
 *
 */
@Named("valueSetService")
@Transactional
class ValueSetServiceImpl extends BaseServiceImpl<ValueSet> implements ValueSetService {
	@Override
	public List<String> getValues(String valueSetName) {
		getDao().getValues(valueSetName)
	}

	@Override
	public BaseDao<ValueSet> getDao() {
		return ServiceLocator.getBean(ValueSetDao.class);
	}
}
