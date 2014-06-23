package hu.okfonok.mail

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.MailException
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage

/**
 * 
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component("registrationMailSender")
class RegistrationMailSender implements Serializable {
	private static final Logger log = LoggerFactory.getLogger(RegistrationMailSender.class)
	 
	@Autowired
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
