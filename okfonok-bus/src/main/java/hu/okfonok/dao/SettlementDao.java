package hu.okfonok.dao;

import java.util.List;

import hu.okfonok.entities.Settlement;

public interface SettlementDao extends BaseDao<Settlement> {
	Settlement findBySettlement(String value);
}
