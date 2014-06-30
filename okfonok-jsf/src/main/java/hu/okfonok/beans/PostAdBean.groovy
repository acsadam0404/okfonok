package hu.okfonok.beans

import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.JobCategory
import hu.okfonok.entities.user.User
import hu.okfonok.services.AdvertisementService
import hu.okfonok.services.JobCategoryService
import hu.okfonok.services.UserService
import hu.okfonok.utils.Config
import hu.okfonok.utils.ServiceLocator;

import javax.faces.model.SelectItem
import javax.faces.model.SelectItemGroup

import org.apache.commons.io.FileUtils
import org.primefaces.event.FileUploadEvent
import org.primefaces.model.StreamedContent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.security.core.userdetails.UserDetailsService;

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
	private AdvertisementService adService
	@Autowired 
	private JobCategoryService jcs
	@Autowired 
	private UserService userService
	@Autowired
	private UserBean userBean
	
	
	
	void post() {
		ad.user = userBean.user
		adService.save(ad);   
	}
}
