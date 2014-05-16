package hu.okfonok.dao.impl

import java.util.List;

import hu.okfonok.dao.UserDao
import hu.okfonok.entities.Settlement;
import hu.okfonok.entities.user.User

import javax.inject.Named
import javax.persistence.TypedQuery

import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Named
@Transactional(propagation = Propagation.MANDATORY)
class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findByUserName(String username) {
		TypedQuery<User> query = em.createQuery("select u from User u where u.userName = '${username}'", User.class)
		return query.singleResult
	}
	
}
