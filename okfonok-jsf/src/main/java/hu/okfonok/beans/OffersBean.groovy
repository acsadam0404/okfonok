package hu.okfonok.beans

import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.Offer
import hu.okfonok.services.AdvertisementService
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
	private AdvertisementService adService
	@Autowired
	private UserBean userBean
	
	List<Advertisement> filteredAds
	
	List<Advertisement> getMyAds() {
		adService.findByUser(userBean.user) 
	}
}
