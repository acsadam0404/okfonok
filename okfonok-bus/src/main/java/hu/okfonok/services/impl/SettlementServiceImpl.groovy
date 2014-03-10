package hu.okfonok.services.impl

import hu.okfonok.dao.BaseDao
import hu.okfonok.dao.SettlementDao
import hu.okfonok.entities.Settlement
import hu.okfonok.services.SettlementService
import hu.okfonok.utils.ServiceLocator

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
	@Override
	public List<Settlement> findAll() {
		getDao().findAll()
	}

	@Override
	public Settlement findBySettlement(String value) {
		getDao().findBySettlement(value)
	}

	@Override
	public BaseDao<Settlement> getDao() {
		return ServiceLocator.getBean(SettlementDao.class)
	}
}