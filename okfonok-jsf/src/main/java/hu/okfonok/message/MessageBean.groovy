package hu.okfonok.message

import hu.okfonok.entities.user.Message
import hu.okfonok.services.MessageService
import hu.okfonok.session.SessionUtils

import org.primefaces.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope

@org.springframework.stereotype.Component("messageBean")
@Scope("session")
class MessageBean {
	@Autowired
	private MessageService service

	List<GroupedMessages> selected
	
	GroupedMessages viewed

	List<GroupedMessages> getIncomingMessages() {
		List<Message> msgs = service.findIncomingMessages(SessionUtils.user)
	
		return GroupedMessages.createFromMessages(msgs)
	}

	List<Message> getOutgoingMessages() {
		List<Message> msgs = service.findOutgoingMessages(SessionUtils.user)
	}

	List<Message> getDeletedMessages() {
		List<Message> msgs = service.findDeletedMessages(SessionUtils.user)
	}
	
	void openDialog(GroupedMessages gmsg) {
		viewed = gmsg
		Map options = [
			draggable: false,
			resizable: false,
			contentWidth: 430,
			contentHeight: 460
		]
		RequestContext.getCurrentInstance().openDialog("fragments/message/viewMessageDialog", options, null);
	}
}
