package hu.okfonok.services.impl

import hu.okfonok.dao.BaseDao
import hu.okfonok.dao.RoleDao
import hu.okfonok.entities.Role
import hu.okfonok.services.RoleService
import hu.okfonok.utils.ServiceLocator

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
	@Override
	Role getUserRole() {		
		getDao().getUserRole()
	}

	@Override
	public BaseDao<Role> getDao() {
		return ServiceLocator.getBean(RoleDao.class);
	}
}
