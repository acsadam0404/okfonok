package hu.jobly.services.impl;

import hu.jobly.entities.User
import hu.jobly.services.UserService

import org.hibernate.criterion.Restrictions
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


/**
 * 
 * @author Ács Ádám
 *
 */
@Repository("userService")
@Transactional
class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Override
	User findByUserName(String userName) {
		return (User) currentSession().createCriteria(User.class).add(Restrictions.eq("userName", userName)).uniqueResult();
	}

	@Override
	List<User> findAll() {
		findAll(User.class)
	}
}
