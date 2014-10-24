package hu.okfonok.services;

import hu.okfonok.entities.Skill;
import hu.okfonok.entities.user.User;

import java.util.List;

public interface SkillService {
	List<Skill> findAll();
	
	List<Skill> findRandom(User user, int count);
}
