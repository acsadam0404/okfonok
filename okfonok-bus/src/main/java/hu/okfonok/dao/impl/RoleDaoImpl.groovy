package hu.okfonok.dao.impl

import hu.okfonok.dao.RoleDao
import hu.okfonok.entities.Role

import javax.inject.Named
import javax.persistence.TypedQuery

@Named
class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{
	@Override
	Role getUserRole() {
		TypedQuery<Role> q2 = em.createQuery("SELECT c FROM Role c where c.name = 'USER_ROLE'", Role.class);
		return q2.singleResult
	}
}
