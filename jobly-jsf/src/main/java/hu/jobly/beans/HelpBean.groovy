package hu.jobly.beans

import javax.faces.application.FacesMessage
import javax.faces.context.FacesContext
import javax.inject.Named

import org.springframework.context.annotation.Scope

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
	String category //TODO combobox

	void sendMail() {
		print "mail sent: $email, $name, $subject, $message"
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Test", "Test " + name));
	}
}
