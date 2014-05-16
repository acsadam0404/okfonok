package hu.okfonok.services.impl

import hu.okfonok.dao.SettlementDao
import hu.okfonok.entities.Settlement
import hu.okfonok.services.SettlementService
import hu.okfonok.utils.ServiceLocator

import javax.inject.Named

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("settlementService")
@Transactional
class SettlementServiceImpl extends BaseServiceImpl<Settlement> implements SettlementService {
	@Autowired 
	private transient SettlementDao repo;
	
	@Autowired
	SettlementServiceImpl(SettlementDao crudRepo) {
		super(crudRepo);
	}
	
	@Override
	List<Settlement> findAll() {
		repo.findAll()
	}

	@Override
	Settlement findBySettlement(String settlement) {
		repo.findBySettlement(settlement)
	}
}