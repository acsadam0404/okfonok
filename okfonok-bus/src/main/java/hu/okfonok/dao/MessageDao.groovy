package hu.okfonok.dao;

import hu.okfonok.entities.user.Message
import hu.okfonok.entities.user.User

import org.springframework.data.jpa.repository.JpaRepository

interface MessageDao extends JpaRepository<Message, Long>{
	List<Message> findByFromUserAndDeletedFalse(User fromUser);

	List<Message> findByToUserAndDeletedFalse(User toUser);

	List<Message> findByFromUserAndDeletedTrue(User fromUser);

	List<Message> findByToUserAndDeletedTrue(User toUser);
}
