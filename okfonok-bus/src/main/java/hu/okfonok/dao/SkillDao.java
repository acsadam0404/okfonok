package hu.okfonok.dao;

import hu.okfonok.entities.Skill;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDao extends JpaRepository<Skill, Long>{
	
}
