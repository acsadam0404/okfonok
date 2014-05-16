package hu.okfonok.dao;

import hu.okfonok.entities.ValueSet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueSetDao extends JpaRepository<ValueSet, Long> {
	List<ValueSet> findByName(String name);
}
