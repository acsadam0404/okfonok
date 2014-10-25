package hu.okfonok.beans;

import hu.okfonok.entities.user.Notification
import hu.okfonok.session.SessionUtils

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("notiBean")
@Scope("session")
class NotificationBean {
	
	int getUnreadNum() {
		return unreadNotis.size()
	}
	
	private List<Notification> getUnreadNotis() {
		def unreadNotis = findAll().collect() {
			!it.isRead
		}
		return unreadNotis
	}
	
	def markAllRead() {
		SessionUtils.user.notifications*.isRead = true
	}
	
	List<Notification> findAll() {
		return new ArrayList(SessionUtils.user.notifications)
	}
}
