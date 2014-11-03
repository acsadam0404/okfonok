

package hu.okfonok.services.impl

import java.util.List;

import hu.okfonok.dao.MessageDao
import hu.okfonok.entities.user.Message
import hu.okfonok.entities.user.User
import hu.okfonok.services.MessageService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {
	
	private transient MessageDao repo
	
	@Autowired
	MessageServiceImpl(MessageDao crudRepo) {
		super(crudRepo);
		repo = crudRepo
	}
	
	@Transactional(readOnly = true)
	@Override
	List<Message> findIncomingMessages(User user) {
		return repo.findByToUserAndDeletedFalse(user)
	}

	@Transactional(readOnly = true)
	@Override
	List<Message> findOutgoingMessages(User user) {
		return repo.findByFromUserAndDeletedFalse(user)
	}

	@Transactional(readOnly = true)
	@Override
	List<Message> findDeletedMessages(User user) {
		def messages = []
		messages.addAll(repo.findByToUserAndDeletedTrue(user))
		messages.addAll(repo.findByToUserAndDeletedTrue(user))
		return messages
	}
}
