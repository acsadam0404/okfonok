package hu.okfonok.services

import hu.okfonok.entities.user.Message
import hu.okfonok.entities.user.User

interface MessageService extends BaseService<Message> {
	List<Message> findIncomingMessages(User user);
	List<Message> findOutgoingMessages(User user);
	List<Message> findDeletedMessages(User user);
}
