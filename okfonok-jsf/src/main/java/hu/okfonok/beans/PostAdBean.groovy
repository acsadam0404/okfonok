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
}
