package hu.okfonok.beans;

import hu.okfonok.mail.SubscriptionMailSender
import hu.okfonok.utils.ServiceLocator

import javax.faces.application.FacesMessage
import javax.faces.context.FacesContext

import org.springframework.context.annotation.Scope

@org.springframework.stereotype.Component("info2Bean")
@Scope("request")
class Info2Bean implements Serializable{
	String email

	def subscribe() {
		ServiceLocator.getBean(SubscriptionMailSender).send(email)
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sikeres feliratkozás",  "Tájékoztatni fogunk. Köszönjük!" ) );
		email = ""
	}
}