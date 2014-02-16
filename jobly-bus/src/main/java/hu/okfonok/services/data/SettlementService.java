package hu.okfonok.services.data;

import hu.okfonok.entities.data.Settlement;

import java.util.List;

/**
 * 
 * @author Ács Ádám
 *
 */
public interface SettlementService {
	List<Settlement> findAll();

	Settlement findBySettlement(String value);
}
