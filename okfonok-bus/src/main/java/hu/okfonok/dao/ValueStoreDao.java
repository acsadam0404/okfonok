package hu.okfonok.dao;

import hu.okfonok.entities.ValueStore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ValueStoreDao extends JpaRepository<ValueStore, Long>{
	@Query("Select vs.value from ValueStore vs where vs.name = :storeName")
	String getValue(String storeName);
}
