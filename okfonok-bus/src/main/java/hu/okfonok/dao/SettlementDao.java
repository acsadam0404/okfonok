package hu.okfonok.dao;

import java.util.List;

import hu.okfonok.entities.Settlement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SettlementDao extends JpaRepository<Settlement, Long> {
	Settlement findBySettlement(String settlement);
	
	//TODO case insensitive szűrés kell
	@Query("select s from Settlement s where s.settlement like %?1% or s.zip like %?1% ")
	List<Settlement> findBySettlementLikeOrZipLike(String query);
}
