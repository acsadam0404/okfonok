package hu.jobly.services.impl

import hu.jobly.entities.Role
import hu.jobly.services.RoleService

import javax.inject.Named
import javax.persistence.TypedQuery

import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("roleService")
@Transactional
class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService  {
	@Override
	Role getUserRole() {		
		TypedQuery<Role> q2 = em.createQuery("SELECT c FROM Role c where c.name = 'USER_ROLE'", Role.class);
		return q2.singleResult
	}
}
