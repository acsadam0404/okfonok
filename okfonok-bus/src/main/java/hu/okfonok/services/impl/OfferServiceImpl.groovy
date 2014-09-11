package hu.okfonok.services.impl

import hu.okfonok.dao.OfferDao
import hu.okfonok.entities.Offer
import hu.okfonok.entities.user.User
import hu.okfonok.services.OfferService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service("offerService")
@Transactional
class OfferServiceImpl extends BaseServiceImpl<Offer> implements OfferService{

	private transient OfferDao repo
	
	@Autowired
	OfferServiceImpl(OfferDao crudRepo) {
		super(crudRepo);
		repo = crudRepo
	}
	
	
	@Override
	List<Offer> findAllForUser(User user) {
		repo.findByAdUser(user)
	}

}
