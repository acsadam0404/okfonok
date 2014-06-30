package hu.okfonok.beans;

import hu.okfonok.entities.Advertisement
import hu.okfonok.services.AdvertisementService
import hu.okfonok.services.JobCategoryService
import hu.okfonok.utils.ServiceLocator

import javax.faces.model.SelectItem

import org.primefaces.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope

@org.springframework.stereotype.Component("adsBean")
@Scope("view")
class AdvertisementsBean implements Serializable {
	@Autowired
	private AdvertisementService service
	@Autowired
	private JobCategoryService jcService

	private List<Advertisement> ads
	List<Advertisement> filteredAds
	Advertisement selected

	List<Advertisement> getAds() {
		if (!ads) {
			ads = service.findAll()
		}

		//FIXME testadat
		ads << new Advertisement(description: 'teszt leírás', jobTime: new Date(), expiration :new Date())
		//FIXME vége
		return ads
	}

	def getMainCategoryOptions() {
		ServiceLocator.getBean(JobCategoryService.class).findAllMain()
	}

	SelectItem[] getSubCategoryOptions() {
		SelectItem[] options = new SelectItem[0] //TODO
		return options
	}

	public void viewAd() {
		Map options = [
			modal: true
			,draggable: false
			,resizable: false
			,contentHeight: 470
			,contentWidth: 620
			,width: 650
			,height: 500
		]

//		RequestContext.getCurrentInstance().openDialog("fragments/index/viewAdDialog", options, null);
		RequestContext.getCurrentInstance().openDialog("test");
	}
}
