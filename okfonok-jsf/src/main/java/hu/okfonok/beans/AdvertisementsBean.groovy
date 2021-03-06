package hu.okfonok.beans;

import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.JobCategory
import hu.okfonok.entities.Offer
import hu.okfonok.services.AdvertisementService
import hu.okfonok.services.JobCategoryService
import hu.okfonok.services.OfferService
import hu.okfonok.services.UserService
import hu.okfonok.session.SessionUtils
import hu.okfonok.utils.ServiceLocator

import javax.faces.model.SelectItem
import javax.faces.model.SelectItemGroup

import org.primefaces.context.RequestContext
import org.primefaces.model.DefaultScheduleModel
import org.primefaces.model.ScheduleModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("adsBean")
@Scope("session")
class AdvertisementsBean implements Serializable {
	@Autowired
	private AdvertisementService service
	@Autowired
	private UserService userService

	@Autowired
	private OfferService offerService
	boolean overlayVisible
	boolean messageVisible

	Advertisement adToView
	Integer offerSum
	
	
	Advertisement selected
	private List<Advertisement> ads
	List<Advertisement> filteredAds
	List<Advertisement> getAds() {
		service.findAll()
	}

	void viewAd(Advertisement ad) {
		adToView = ad
		Map options = [
			draggable: false,
			resizable: false,
			contentWidth: 430,
			contentHeight: 460
		]
		RequestContext.getCurrentInstance().openDialog("fragments/index/viewAdDialog", options, null);
	}

	void closeAd() {
		RequestContext.getCurrentInstance().closeDialog("fragments/index/viewAdDialog");
	}


	List<SelectItem> getCategories() {
		JobCategoryService service = ServiceLocator.getBean(JobCategoryService)
		List<SelectItem> categories = []
		service.findAllMain().each { JobCategory maincat ->
			SelectItemGroup g = new SelectItemGroup(maincat.name);
			List<SelectItem> items = []
			maincat.subCategories?.each { JobCategory subcat ->
				items << new SelectItem(subcat, subcat.name)
			}
			g.setSelectItems(items as SelectItem[])
			categories.add(g)
		}

		return categories
	}

	boolean isSaved(Advertisement ad) {
		boolean saved = SessionUtils.user.savedAds.contains(ad)
		return saved
	}

	void saveAd(Advertisement ad) { 
		if (!SessionUtils.user.savedAds.contains(ad)) {
			SessionUtils.user.savedAds.add(ad)
			userService.save(SessionUtils.user)
		}
	}
	
	def offer() {
		if (offerSum) {
			Offer offer = new Offer(ad: adToView, user: SessionUtils.user,  offer: offerSum)
			offerService.save(offer) 
		}
	}

	void removeAd(Advertisement ad) {
		if (SessionUtils.user.savedAds.contains(ad)) {
			SessionUtils.user.savedAds.remove(ad)
			userService.save(SessionUtils.user)
		}
	}

	//TODO
	void shareAd(Advertisement ad) {
		print ad.toString() + ' megosztva'
	}
}
