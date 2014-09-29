package hu.okfonok.message

import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.user.Message
import hu.okfonok.entities.user.User
import hu.okfonok.services.MessageService
import hu.okfonok.session.SessionUtils
import hu.okfonok.utils.ServiceLocator

import org.apache.log4j.Logger
import org.springframework.context.annotation.Scope

@org.springframework.stereotype.Component("messageSenderBean")
@Scope("request")
class MessageSenderBean implements Serializable {
	private static final Logger log = Logger.getLogger(MessageSenderBean)
	
	private User user
	String text
	Advertisement advertisement

	void send() {
		log.info "sent message from $SessionUtils.user to $user.userName message: $text"
		
		Message msg = new Message(SessionUtils.user, user, text, advertisement)
		ServiceLocator.getBean(MessageService).save(msg)
	}
	
	void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement
		this.user = advertisement.user
	}
}
