package hu.okfonok.services.impl

import hu.okfonok.dao.RoleDao
import hu.okfonok.entities.Role
import hu.okfonok.services.RoleService
import hu.okfonok.utils.ServiceLocator

import javax.inject.Named

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

/**
 * 
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component("roleService")
@Transactional
class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService  {
	@Autowired
	private transient RoleDao repo;
	
	@Autowired
	RoleServiceImpl(RoleDao crudRepo) {
		super(crudRepo);
	}
	
	@Override
	Role getUserRole() {		
		repo.userRole
	}
}
