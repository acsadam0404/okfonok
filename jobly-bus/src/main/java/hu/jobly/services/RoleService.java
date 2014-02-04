package hu.jobly.services;

import hu.jobly.entities.Role;

/**
 * 
 * @author Ács Ádám
 *
 */
public interface RoleService extends BaseService<Role> {
	Role getUserRole();
}
