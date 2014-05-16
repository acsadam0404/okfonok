package hu.okfonok.dao;

import hu.okfonok.entities.user.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
	User findByUserName(String userName);
}
