package hu.okfonok.message;

import static org.junit.Assert.*
import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.user.Message
import hu.okfonok.entities.user.User

import org.junit.Test

public class GroupedMessagesTest {

	@Test
	public void test() {
		GroupedMessages.createFromMessages(createData()).each {
			println it.user
			println it.advertisement
			println it.messages
			println '------------------'
		}
	}

	List<Message> createData() {
		def user = new User(userName: "Teszt User")
		def ad1 = new Advertisement(description: "test", user: user)
		def ad2 = new Advertisement(description: "test2", user: user)

		def msg1 = new Message(user, user, 'testad1', ad1)
		def msg2 = new Message(user, user, "test2ad1", ad1)
		def msg3 = new Message(user, user, "testad2", ad2)

		return [msg1, msg2, msg3]
	}
}
