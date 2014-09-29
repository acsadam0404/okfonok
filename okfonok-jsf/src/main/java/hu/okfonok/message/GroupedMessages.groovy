package hu.okfonok.message

import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.user.Message
import hu.okfonok.entities.user.User

class GroupedMessages {
	Advertisement advertisement
	User user
	List<Message> messages


	static List<GroupedMessages> createFromMessages(List<Message> messages) {
		Map<Advertisement, List> msgsByAd = messages.groupBy { msg -> msg.advertisement }

		def groups = []
		msgsByAd.each { k, v ->
			def groupedByUser = v.groupBy { msg -> msg.'fromUser' }

			groupedByUser.each { k2, v2 ->
				GroupedMessages m = new GroupedMessages(advertisement: k)
				m.user = k2
				m.messages = v2
				groups << m
			}
		}

		return groups
	}

	Date getLatestDatum() {
		return messages.max { a, b -> b.datum <=> a.datum }.datum
	}
}
