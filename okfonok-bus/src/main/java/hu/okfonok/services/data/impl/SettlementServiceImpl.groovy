package hu.okfonok.services.data.impl

import hu.okfonok.entities.data.Settlement
import hu.okfonok.services.data.SettlementService

import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("settlementService")
@Transactional
class SettlementServiceImpl extends DataServiceImpl<Settlement> implements SettlementService {
	@Override
	public List<Settlement> findAll() {
		return em.createQuery("from Settlement").resultList;
	}

	@Override
	public Settlement findBySettlement(String value) {
		return em.createQuery("from Settlement where settlement = '${value}'").singleResult;
	}
}
