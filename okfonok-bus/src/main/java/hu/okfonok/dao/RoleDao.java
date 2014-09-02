package hu.okfonok.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.okfonok.entities.Role;

public interface RoleDao extends JpaRepository<Role, Long>{
	@Query("select r from Role r where r.name = 'USER_ROLE'")
	Role getUserRole();
}
