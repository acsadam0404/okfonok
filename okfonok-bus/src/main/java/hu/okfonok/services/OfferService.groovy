package hu.okfonok.services

import hu.okfonok.entities.Offer
import hu.okfonok.entities.user.User

interface OfferService extends BaseService<Offer>{
	List<Offer> findAllForUser(User user);
}
