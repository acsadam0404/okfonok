package hu.okfonok.services.impl

import hu.okfonok.dao.RoleDao
import hu.okfonok.entities.Role
import hu.okfonok.services.RoleService

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("roleService")
@Transactional
class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService  {
	@Inject
	private RoleDao dao;
	
	@Override
	Role getUserRole() {		
		dao.getUserRole()
	}
}
