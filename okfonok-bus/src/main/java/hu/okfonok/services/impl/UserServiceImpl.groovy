package hu.okfonok.services.impl;

import hu.okfonok.entities.user.User;
import hu.okfonok.services.UserService

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
