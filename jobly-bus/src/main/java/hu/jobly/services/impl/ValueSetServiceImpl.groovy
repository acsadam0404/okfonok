package hu.jobly.services.impl

import java.util.List;

import hu.jobly.entities.ValueSet
import hu.jobly.services.ValueSetService

import javax.inject.Named
import javax.persistence.TypedQuery;

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
		TypedQuery<ValueSet> query = em.createQuery("from ValueSet where name = '${valueSetName}'", ValueSet.class)
		return query.getSingleResult().values 
	}
	
	@Override
	List<String> getHelpCategories() {
		return getValues("helpCategory")
	}

}
