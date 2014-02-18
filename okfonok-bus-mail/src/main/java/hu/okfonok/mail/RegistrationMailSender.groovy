package hu.okfonok.mail

import hu.okfonok.mail.RegistrationMailSender;

import javax.inject.Inject
import javax.inject.Named

import org.slf4j.Logger
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("registrationMailSender")
class RegistrationMailSender {
	private static final Logger log = LoggerFactory.getLogger(RegistrationMailSender.class)
	 
	@Inject
	private MailSender mailSender

	void send() {

		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setFrom("acsadam0404@gmail.com")
		msg.setTo("acsadam0404@gmail.com")
		msg.setText("okfonok")
		msg.setSubject("okfonok")
		
		try {
			mailSender.send(msg);
			log.info("Sikeres üzenetküldés. Üzenet:\n ${msg.to}\n${msg.subject}\n${msg.text}");
		} 
		catch (MailException mex) {
			log.error("Sikertelen üzenet küldés regisztrációkor. Üzenet:\n ${msg.from}\n${msg.to}\n${msg.subject}\n${msg.text}", mex);
		}
	}
}
