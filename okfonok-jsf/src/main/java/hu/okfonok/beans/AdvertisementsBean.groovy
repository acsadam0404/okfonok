package hu.okfonok.beans;

import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.JobCategory
import hu.okfonok.services.AdvertisementService
import hu.okfonok.services.JobCategoryService

import javax.faces.model.SelectItem
import javax.inject.Inject
import javax.inject.Named

import org.springframework.context.annotation.Scope

@Named("advertisementsBean")
@Scope("view")
class AdvertisementsBean implements Serializable {
	@Inject private AdvertisementService service;
	@Inject private JobCategoryService jcService;

	private List<Advertisement> ads;
	List<Advertisement> filteredAds;

	List<Advertisement> getAds() {
		if (!ads) {
			ads = service.findAll()
			println ads
		}
		return ads
	}

	SelectItem[] getMainCategoryOptions() {
		List<JobCategory> mains = jcService.findAllMain()
		SelectItem[] options = new SelectItem[mains.size()]   
		for (int i = 0; i < mains.size(); i++) {
			options[i] = new SelectItem(mains.get(i), mains.get(i).name)
		}
		return options
	}
	
	SelectItem[] getSubCategoryOptions() {
		SelectItem[] options = new SelectItem[0] //TODO
		return options
	}
}
