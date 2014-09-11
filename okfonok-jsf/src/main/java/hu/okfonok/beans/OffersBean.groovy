package hu.okfonok.beans

import java.util.List;

import hu.okfonok.entities.Advertisement;
import hu.okfonok.entities.Offer
import hu.okfonok.services.OfferService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("offersBean")
@Scope("session")
class OffersBean {
	@Autowired
	private OfferService service
	@Autowired
	private UserBean userBean
	
	private List<Offer> offers
	List<Offer> filteredOffer
	Offer selected
	
	List<Offer> getOffers() {
		service.findAllForUser(userBean.user)
	}
}
