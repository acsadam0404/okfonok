package hu.okfonok.services.impl

import hu.okfonok.dao.SettlementDao
import hu.okfonok.entities.Settlement
import hu.okfonok.services.SettlementService

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("settlementService")
@Transactional
class SettlementServiceImpl extends BaseServiceImpl<Settlement> implements SettlementService {
	@Inject
	private SettlementDao dao;

	@Override
	public List<Settlement> findAll() {
		dao.findAll()
	}

	@Override
	public Settlement findBySettlement(String value) {
		dao.findBySettlement(value)
	}
}