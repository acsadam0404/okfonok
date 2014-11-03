package hu.okfonok.services;

import hu.okfonok.entities.Address;
import hu.okfonok.entities.Advertisement;
import hu.okfonok.entities.user.User;

import java.util.List;
import java.util.Map;

public interface AdvertisementService  extends BaseService<Advertisement>{
	
	Map<String, String> getRemunerations();
	
	//TODO: valueset
	//List<String> getRemunerations();
	
	List<String> getAdBearerTypes();
	
	String getDistance(Address adress);

	String getAvgPrice(Advertisement ad);
	
	List<Advertisement> findByUser(User user);
}
