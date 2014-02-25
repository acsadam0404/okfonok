package hu.okfonok.services.impl;

import hu.okfonok.dao.UserDao
import hu.okfonok.entities.user.User
import hu.okfonok.services.UserService

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional


/**
 * 
 * @author Ács Ádám
 *
 */
@Named("userService")
@Transactional
class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Inject
	private UserDao dao;
	
	@Override
	User findByUserName(String userName) {
		dao.findByUserName(userName)
	}

}
