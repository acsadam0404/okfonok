package hu.okfonok.services.impl

import hu.okfonok.dao.AdvertisementDao
import hu.okfonok.entities.Advertisement
import hu.okfonok.services.AdvertisementService

import javax.inject.Named

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

@Named("advertisementService")
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
		repo.findAll()
	}

}
