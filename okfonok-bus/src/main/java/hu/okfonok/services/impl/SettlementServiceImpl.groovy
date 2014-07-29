package hu.okfonok.services.impl

import java.util.List;

import hu.okfonok.dao.SettlementDao
import hu.okfonok.entities.Settlement
import hu.okfonok.services.SettlementService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 */
@Service("settlementService")
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

	@Override
	List<Settlement> findBySettlementOrZipLike(String query) {
		repo.findBySettlementLikeOrZipLike(query)
	}
}