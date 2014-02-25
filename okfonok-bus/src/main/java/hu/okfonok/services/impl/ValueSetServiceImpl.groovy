package hu.okfonok.services.impl

import hu.okfonok.dao.ValueSetDao
import hu.okfonok.entities.ValueSet
import hu.okfonok.services.ValueSetService

import javax.inject.Inject
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
	@Inject
	private ValueSetDao dao;
	
	@Override
	public List<String> getValues(String valueSetName) {
		dao.getValues(valueSetName)
	}
}
