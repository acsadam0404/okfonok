package hu.okfonok.services.impl

import hu.okfonok.dao.AdvertisementDao
import hu.okfonok.entities.Advertisement
import hu.okfonok.services.AdvertisementService

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

@Named("advertisementService")
@Transactional
class AdvertisementServiceImpl extends BaseServiceImpl<Advertisement> implements AdvertisementService{
	@Inject
	private AdvertisementDao dao;
	
	@Override
	public List<String> getRemunerations() {
		return ['Fix', 'Óradíjas'];
	}

	@Override
	public List<String> getAdBearerTypes() {
		return ['Magánszemély', 'Cég' ];
	}

}
