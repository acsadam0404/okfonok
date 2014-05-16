package hu.okfonok.dao.impl

import hu.okfonok.dao.ValueSetDao
import hu.okfonok.entities.ValueSet

import javax.inject.Named
import javax.persistence.NoResultException
import javax.persistence.TypedQuery

@Named
class ValueSetDaoImpl  extends BaseDaoImpl<ValueSet> implements ValueSetDao{

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
