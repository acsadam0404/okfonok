package hu.okfonok.dao.impl

import hu.okfonok.dao.SettlementDao
import hu.okfonok.entities.Settlement

import javax.inject.Named

@Named
class SettlementDaoImpl extends BaseDaoImpl<Settlement> implements SettlementDao {
	@Override
	public Settlement findBySettlement(String value) {
		return em.createQuery("from Settlement where settlement = '${value}'").singleResult;
	}
}
