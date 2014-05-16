package hu.okfonok.beans

import hu.okfonok.mail.HelpMailSender

import javax.faces.application.FacesMessage
import javax.faces.context.FacesContext
import javax.inject.Inject
import javax.inject.Named

import org.springframework.context.annotation.Scope
import org.springframework.mail.MailException

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("helpBean")
@Scope("view")
class HelpBean implements Serializable {
	String email
	String name
	String subject
	String message
	String category

	@Inject
	private HelpMailSender helpMailSender

	void sendMail() {
		FacesContext context = FacesContext.getCurrentInstance();


		try {
			helpMailSender.send(email, name, subject, category, message)
			context.addMessage(null, new FacesMessage("A küldés sikeres"));
		} catch (MailException mex) {
			context.addMessage(null, new FacesMessage("A küldés sikertelen"));
		}
	}
}
