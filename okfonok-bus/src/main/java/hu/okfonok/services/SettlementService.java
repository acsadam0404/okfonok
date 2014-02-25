package hu.okfonok.services;

import hu.okfonok.entities.Settlement;

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
