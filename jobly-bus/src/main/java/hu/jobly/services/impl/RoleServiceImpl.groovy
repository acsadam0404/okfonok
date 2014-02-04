package hu.jobly.services.impl

import hu.jobly.entities.Role
import hu.jobly.services.RoleService
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 */
@Repository("roleService")
@Transactional
class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService  {
	@Override
	Role getUserRole() {
		List<Role> roles = super.findAll(Role.class)
		def userRole = roles.find() { it.name = 'ROLE_USER' }
		return userRole
	}

	@Override
	List<Role> findAll() {
		findAll(Role.class)
	}
}
