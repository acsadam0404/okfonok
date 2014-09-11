package hu.okfonok.services

import hu.okfonok.entities.Offer;
import hu.okfonok.entities.user.User;

import java.util.List;

interface OfferService {
	List<Offer> findAllForUser(User user);
}
