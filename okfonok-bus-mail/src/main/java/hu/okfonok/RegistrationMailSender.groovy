package hu.okfonok

import org.springframework.mail.MailException
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage

/**
 * 
 * @author Ács Ádám
 *
 */
class RegistrationMailSender {
	private MailSender mailSender;
	private SimpleMailMessage templateMessage;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}

	public void send() {

		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setTo("acsadam0404@gmail.com");
		msg.setText("fuck that shit $mailSender");
		try{
			this.mailSender.send(msg);
		}
		catch(MailException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
