package hu.okfonok.services.impl;

import hu.okfonok.dao.BaseDao
import hu.okfonok.dao.UserDao
import hu.okfonok.entities.user.User
import hu.okfonok.services.UserService
import hu.okfonok.utils.ServiceLocator

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
	@Override
	User findByUserName(String userName) {
		getDao().findByUserName(userName)
	}

	@Override
	public BaseDao<User> getDao() {
		return ServiceLocator.getBean(UserDao.class);
	}
	
	@Override
	public List<User> findAll() {
		return getDao().findAll(User.class)
	}

}
