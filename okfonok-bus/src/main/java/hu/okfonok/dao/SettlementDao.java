package hu.okfonok.dao;

import hu.okfonok.entities.Settlement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementDao extends JpaRepository<Settlement, Long> {
	Settlement findBySettlement(String settlement);
}
