package hu.jobly.services.impl;

import hu.jobly.entities.User
import hu.jobly.services.UserService

import javax.inject.Named
import javax.persistence.TypedQuery

import org.springframework.transaction.annotation.Transactional


/**
 * 
 * @author Ács Ádám
 *
 */
@Named("userService")
@Transactional
class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Override
	User findByUserName(String userName) {
		TypedQuery<User> query = em.createQuery("select u from User u where u.userName = '${userName}'", User.class)
		return query.singleResult
	}
}
