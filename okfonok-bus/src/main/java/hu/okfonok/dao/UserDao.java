package hu.okfonok.dao;

import hu.okfonok.entities.user.User;

public interface UserDao extends BaseDao<User> {
	User findByUserName(String username);
}
