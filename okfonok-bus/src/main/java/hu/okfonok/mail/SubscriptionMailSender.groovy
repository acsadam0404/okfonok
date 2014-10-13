package hu.okfonok.mail

import hu.okfonok.utils.Config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.MailException
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage

@org.springframework.stereotype.Component("subscriptionMailSender")
class SubscriptionMailSender {
	private static final Logger log = LoggerFactory.getLogger(RegistrationMailSender.class)

	@Autowired
	private transient MailSender mailSender

	void send(String mail) {
		new Thread() {
			@Override
			void run() {
				SimpleMailMessage msg = new SimpleMailMessage();
				
				msg.setFrom(mail)
				msg.setTo(Config.supportEmail)
				msg.setText("OKFőnök feliratkozási kérelem: $mail")
				msg.setSubject("OKFőnök feliratkozási kérelem")
		
				try {
					mailSender.send(msg);
					log.info("Sikeres üzenetküldés. Üzenet:\n ${msg.to}\n${msg.subject}\n${msg.text}");
				}
				catch (MailException mex) {
					log.error("Sikertelen üzenet küldés regisztrációkor. Üzenet:\n ${msg.from}\n${msg.to}\n${msg.subject}\n${msg.text}", mex);
				}
			};
		}.start()
	
	}
}
