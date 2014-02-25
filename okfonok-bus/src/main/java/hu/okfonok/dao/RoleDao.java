package hu.okfonok.dao;

import hu.okfonok.entities.Role;

public interface RoleDao extends BaseDao<Role>{
	Role getUserRole();
}
