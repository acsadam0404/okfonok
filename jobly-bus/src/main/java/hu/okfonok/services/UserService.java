package hu.okfonok.services;

import hu.okfonok.entities.User;

/**
 * 
 * @author Ács Ádám
 *
 */
public interface UserService extends BaseService<User> {
	User findByUserName(String username);
}
