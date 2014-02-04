package hu.jobly.services;

import hu.jobly.entities.User;

/**
 * 
 * @author Ács Ádám
 *
 */
public interface UserService extends BaseService<User> {
	User findByUserName(String username);
}
