package hu.okfonok.services;

import hu.okfonok.entities.Advertisement;

import java.util.List;

public interface AdvertisementService  extends BaseService<Advertisement>{
	List<String> getRemunerations();
	
	List<String> getAdBearerTypes();
}
