package hu.okfonok.entities.user

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.BaseEntity

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "message")
@Entity
@EqualsAndHashCode
class Message extends BaseEntity {
	/**
	 * hibernatenek kell, de nem ezt kell használni 
	 */
	Message() {
		/* hibernatenek kell, de nem ezt kell használni */
	}

	Message(User fromUser, User toUser, String text, Advertisement advertisement) {
		this.text = text
		this.fromUser = fromUser
		this.toUser = toUser
		this.advertisement = advertisement
	}

	@NotNull
	private String text

	@ManyToOne
	private User fromUser

	@ManyToOne
	private User toUser

	@NotNull
	private Date datum = new Date()

	private boolean isRead

	boolean deleted
	
	@ManyToOne
	private Advertisement advertisement

	String getText() {
		return text
	}

	User getFromUser() {
		return fromUser
	}
	
	User getToUser() {
		return toUser
	}

	Date getDatum() {
		return datum
	}

	boolean isRead() {
		return isRead
	}

	public Advertisement getAdvertisement() {
		return advertisement;
	}
}
