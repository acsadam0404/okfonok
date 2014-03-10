package hu.okfonok.services.impl

import hu.okfonok.dao.AdvertisementDao
import hu.okfonok.entities.Advertisement
import hu.okfonok.services.AdvertisementService
import hu.okfonok.utils.ServiceLocator

import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

@Named("advertisementService")
@Transactional
class AdvertisementServiceImpl extends BaseServiceImpl<Advertisement> implements AdvertisementService{
	AdvertisementDao getDao() {
		ServiceLocator.getBean(AdvertisementDao.class)
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
	public List<Advertisement> findAll() {
		getDao().findAll(Advertisement.class)
	}

}
