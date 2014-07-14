package hu.okfonok.beans;

import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.JobCategory
import hu.okfonok.services.AdvertisementService
import hu.okfonok.services.JobCategoryService
import hu.okfonok.services.UserService;
import hu.okfonok.utils.ServiceLocator

import javax.faces.model.SelectItem
import javax.faces.model.SelectItemGroup

import org.primefaces.context.RequestContext
import org.primefaces.model.DefaultScheduleModel
import org.primefaces.model.ScheduleModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component("adsBean")
@Scope("session")
class AdvertisementsBean implements Serializable {
	@Autowired
	private AdvertisementService service
	@Autowired
	private JobCategoryService jcService
	@Autowired
	private UserBean userBean
	@Autowired
	private UserService userService
	
	@Autowired
	private MapBean mapBean
	
	ScheduleModel eventModel = new DefaultScheduleModel()

	private List<Advertisement> ads
	List<Advertisement> filteredAds
	Advertisement selected
	Advertisement adToView

	List<Advertisement> getAds() {
		if (!ads) {
			ads = service.findAll()
		}

		return ads
	}

	void viewAd(Advertisement ad) {
		adToView = ad
		Map options = [
			modal: true
			,draggable: false
			,resizable: false
			,contentWidth: 480
			,width: 510
			,contentHeight: 530
			,height: 560
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
		boolean saved = userBean.user.savedAds.contains(ad)
		return saved
	}
	
	void saveAd(Advertisement ad) {
		if (!userBean.user.savedAds.contains(ad)) {
			userBean.user.savedAds.add(ad)
			userService.save(userBean.user)
		}
	}
	
	void removeAd(Advertisement ad) {
		if (userBean.user.savedAds.contains(ad)) {
			userService.removeSavedAd(userBean.user, ad)
			userBean.user.savedAds.remove(ad)
		}
	}
	
	//TODO
	void shareAd(Advertisement ad) {
		print ad + ' megosztva'
	}
}
