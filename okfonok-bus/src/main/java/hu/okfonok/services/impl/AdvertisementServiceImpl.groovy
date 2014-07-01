package hu.okfonok.services.impl

import hu.okfonok.dao.AdvertisementDao
import hu.okfonok.entities.Advertisement
import hu.okfonok.services.AdvertisementService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service("advertisementService")
@Scope("singleton")
@Transactional
class AdvertisementServiceImpl extends BaseServiceImpl<Advertisement> implements AdvertisementService{
	@Autowired
	private transient AdvertisementDao repo;
	
	@Autowired
	AdvertisementServiceImpl(AdvertisementDao crudRepo) {
		super(crudRepo);
	}
	
	@Override
	public List<String> getRemunerations() {
		return ['Fix', 'Óradíjas'];
	}

	@Override
	public List<String> getAdBearerTypes() {
		return ['Magánszemély', 'Cég' ];
	}
	
	@Override
	List<Advertisement> findAll() {
		List<Advertisement> ads = repo.findAll()
		if (!ads) {
			ads  = []
		}
		return ads
	}

}
