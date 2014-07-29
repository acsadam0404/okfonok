package hu.okfonok.services.impl;

import hu.okfonok.dao.UserDao
import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.user.User
import hu.okfonok.services.UserService

import javax.persistence.EntityManager

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


/**
 * 
 * @author Ács Ádám
 *
 */
@Service("userService")
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
