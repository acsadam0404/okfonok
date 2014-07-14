package hu.okfonok.beans

import hu.okfonok.entities.Advertisement
import hu.okfonok.services.AdvertisementService
import hu.okfonok.services.JobCategoryService
import hu.okfonok.services.UserService

import org.primefaces.context.RequestContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component("postAdBean")
@Scope("session")
class PostAdBean implements Serializable{
	Advertisement ad = new Advertisement()
	
	@Autowired
	private AdvertisementsBean adsBean
	
	@Autowired 
	private AdvertisementService adService
	@Autowired 
	private JobCategoryService jcs
	@Autowired 
	private UserService userService
	@Autowired
	private UserBean userBean
	
	
	
	String post() {
		ad.user = userBean.user
		adService.save(ad)
		RequestContext.getCurrentInstance().execute("postadDialog.hide();")
		ad = new Advertisement()
		
		return 'index.xhtml'
	}
}
