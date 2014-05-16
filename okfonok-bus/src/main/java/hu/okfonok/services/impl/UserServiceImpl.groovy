package hu.okfonok.services.impl;

import hu.okfonok.dao.UserDao
import hu.okfonok.entities.user.User
import hu.okfonok.services.UserService
import hu.okfonok.utils.ServiceLocator

import javax.inject.Named

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional


/**
 * 
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component("userService")
@Transactional
class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Autowired
	private transient UserDao repo;

	@Autowired
	UserServiceImpl(UserDao crudRepo) {
		super(crudRepo);
	}

	@Override
	User findByUserName(String userName) {
		repo.findByUserName(userName)
	}

	@Override
	public List<User> findAll() {
		repo.findAll()
	}
}
