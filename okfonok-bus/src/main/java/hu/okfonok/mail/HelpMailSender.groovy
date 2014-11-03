package hu.okfonok.mail

import hu.okfonok.services.ValueSetService
import hu.okfonok.utils.Config
import hu.okfonok.utils.ServiceLocator

import javax.annotation.PostConstruct

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.mail.MailException
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage

/**
 * 
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component("helpMailSender")
@Scope("session")
class HelpMailSender implements Serializable{
	private static final Logger log = LoggerFactory.getLogger(HelpMailSender.class)

	@Autowired
	private transient MailSender mailSender

	@Autowired
	private transient ValueSetService valueSetService

	void send(String email, String name, String subject, String category, String message) {
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom("${email}")
		msg.setTo(Config.supportEmail)

		msg.setSubject("${subject}")
		msg.setText("${message}")
		try {
			MailSender mailSender = ServiceLocator.getBean(MailSender.class);
			mailSender.send(msg);
			log.info("Sikeres üzenetküldés. Üzenet:\n ${msg.to}\n${msg.subject}\n${msg.text}");
		}
		catch (MailException mex) {
			log.error("Sikertelen üzenet küldés segítségkérésnél. Üzenet:\n ${msg.from}\n${msg.to}\n${msg.subject}\n${msg.text}", mex);
			throw mex
		}
	}
}
