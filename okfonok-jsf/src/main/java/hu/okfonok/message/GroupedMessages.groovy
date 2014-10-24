package hu.okfonok.message

import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.user.Message
import hu.okfonok.entities.user.User
import hu.okfonok.services.MessageService;
import hu.okfonok.utils.ServiceLocator;

class GroupedMessages {
	Advertisement advertisement
	User user
	List<Message> messages

	static List<GroupedMessages> createFromMessages(List<Message> messages, String groupBy) {
		Map<Advertisement, List> msgsByAd = messages.groupBy { msg -> msg.advertisement }

		def groups = []
		msgsByAd.each { k, v ->
			def groupedByUser = v.groupBy { msg -> msg."$groupBy" }

			groupedByUser.each { k2, v2 ->
				GroupedMessages m = new GroupedMessages(advertisement: k)
				m.user = k2
				m.messages = v2
				if (!m.deleted) {
					groups << m
				}
			}
		}

		return groups
	}

	Date getLatestDatum() {
		return messages.max { a, b -> b.datum <=> a.datum }.datum
	}

	def setDeleted(boolean deleted) {
		messages?.each { 
			it.deleted = deleted 
			ServiceLocator.getBean(MessageService).save(it)
		}
	}
	
	/**
	 * csak tömegesen lehet üzeneteket törölni, ezért ha van benne törölt üzenet akkor törölt az egész
	 * @return
	 */
	boolean isDeleted() {
		boolean hasDeletedMsg = messages?.collect() { it.deleted}
		return !hasDeletedMsg
	}
}
