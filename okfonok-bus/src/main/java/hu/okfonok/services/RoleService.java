package hu.okfonok.services;

import hu.okfonok.entities.Role;

/**
 * 
 * @author Ács Ádám
 *
 */
public interface RoleService extends BaseService<Role> {
	Role getUserRole();
}
