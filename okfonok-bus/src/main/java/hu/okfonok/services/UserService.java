package hu.okfonok.services;

import hu.okfonok.entities.user.User;

/**
 * 
 * @author Ács Ádám
 *
 */
public interface UserService extends BaseService<User> {
	User findByUserName(String username);
}
