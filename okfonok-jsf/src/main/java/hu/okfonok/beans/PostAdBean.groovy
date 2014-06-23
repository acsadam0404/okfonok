package hu.okfonok.beans

import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.JobCategory
import hu.okfonok.entities.user.User
import hu.okfonok.services.AdvertisementService
import hu.okfonok.services.JobCategoryService
import hu.okfonok.services.UserService
import hu.okfonok.utils.Config

import javax.faces.model.SelectItem
import javax.faces.model.SelectItemGroup

import org.apache.commons.io.FileUtils
import org.primefaces.event.FileUploadEvent
import org.primefaces.model.StreamedContent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component("postAdBean")
@Scope("view")
class PostAdBean implements Serializable{
	JobCategory category
	
	Advertisement ad = new Advertisement()
	
	@Autowired 
	private AdvertisementService adService
	@Autowired 
	private JobCategoryService jcs
	@Autowired 
	private UserService userService
	
	
	
	void post() {
		adService.save(ad);
	}
	
	List<SelectItem> getCategories() {
		List<SelectItem> categories = []
		SelectItemGroup g1 = new SelectItemGroup("German Cars");
		SelectItem[] list1 = [new SelectItem("BMW", "BMW"), new SelectItem("Mercedes", "Mercedes"), new SelectItem("Volkswagen", "Volkswagen")]
		g1.setSelectItems(list1);
		 
		SelectItemGroup g2 = new SelectItemGroup("American Cars");
		SelectItem[] list2 = [new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"), new SelectItem("Ford", "Ford")]
		g2.setSelectItems(list2);
		
		categories.add(g1);
		categories.add(g2);
		
		return categories
	}
}
