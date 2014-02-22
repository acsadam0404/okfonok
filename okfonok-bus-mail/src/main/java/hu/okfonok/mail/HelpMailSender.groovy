package hu.okfonok.mail

import hu.okfonok.services.ValueSetService
import hu.okfonok.utils.Config
import hu.okfonok.utils.ServiceLocator

import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.inject.Named

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Scope
import org.springframework.mail.MailException
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("helpMailSender")
@Scope("session")
class HelpMailSender implements Serializable{
	private static final Logger log = LoggerFactory.getLogger(HelpMailSender.class)

	@Inject
	private transient MailSender mailSender

	@Inject
	private transient ValueSetService valueSetService

	private String to

	@PostConstruct
	void init() {
		to = valueSetService.getValues('help_mail')
	}

	void send(String email, String name, String subject, String category, String message) {
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom("${email}")
		msg.setTo("acsadam0404@gmail.com")
		msg.setSubject(new File("${Config.emailTemplatePath}/helpTemplate.txt").getText('UTF-8')) // TODO bind variables

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
