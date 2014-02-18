package hu.okfonok.services.impl

import java.util.List;

import hu.okfonok.entities.ValueSet
import hu.okfonok.services.ValueSetService

import javax.inject.Named
import javax.persistence.NoResultException;
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
		try {
			return query.getSingleResult().values
		}
		catch (NoResultException nrex) {
			return Collections.emptyList()
		}
	}
}
