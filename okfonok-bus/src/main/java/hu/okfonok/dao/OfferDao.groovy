package hu.okfonok.dao

import org.springframework.data.jpa.repository.JpaRepository;

import hu.okfonok.entities.Offer
import hu.okfonok.entities.Settlement;
import hu.okfonok.entities.user.User

interface OfferDao extends JpaRepository<Offer, Long> {
	/**
	 * Az ajánlathoz tartozó hirdetést feladó felhasználó alapján keres. Ez kell az ajánlatok táblázatnak.
	 */
	List<Offer> findByAdUser(User user);
}
