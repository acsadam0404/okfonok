package hu.okfonok.beans

import hu.okfonok.entities.Advertisement
import hu.okfonok.entities.JobCategory
import hu.okfonok.entities.user.User
import hu.okfonok.services.AdvertisementService
import hu.okfonok.services.JobCategoryService
import hu.okfonok.services.UserService
import hu.okfonok.utils.Config

import javax.inject.Inject
import javax.inject.Named

import org.apache.commons.io.FileUtils
import org.primefaces.event.FileUploadEvent
import org.primefaces.model.StreamedContent
import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("postAdBean")
@Scope("view")
class PostAdBean implements Serializable{
	boolean phoneEdit
	boolean phoneEditOnProfile
	Integer phoneNumber

	boolean emailEdit
	boolean emailEditOnProfile
	String email
	
	JobCategory mainCategory
	JobCategory subCategory
	
	Date from
	Date to
	
	Advertisement ad = new Advertisement()
	
	@Inject private AdvertisementService adService
	@Inject private UserBean userBean
	@Inject private JobCategoryService jcs
	@Inject private UserService userService
	
	transient private FileUploadEvent[] uploadEvents = []
	
	transient StreamedContent image1
	transient StreamedContent image2
	transient StreamedContent image3
	transient StreamedContent image4
	
	def switchPhoneEdit() {
		phoneEdit = !phoneEdit
	}

	def phoneEdited() {
		if (phoneEditOnProfile) {
			userBean.user.profile.phoneNumber = phoneNumber
			userBean.user = userService.save(userBean.user)
		}
	}
	
	def switchEmailEdit() {
		emailEdit = !emailEdit
	}

	def emailEdited() {
		if (emailEditOnProfile) {
			userBean.user.profile.email = email
			userBean.user = userService.save(userBean.user)
			// TODO email küldése előbb
		}
	}
	
	List<JobCategory> findSubByMainCategory() {
		if (mainCategory) {
			return jcs.findSubsByMain(mainCategory.id)
		}
		return []
	}
	
	void pictureUpload(FileUploadEvent event) {
		uploadEvents << event
	}
	
	void post() {
		adService.save(ad);
		uploadEvents.each { FileUploadEvent event ->
			String path = "${Config.userProfilePath}/${userBean.user.userName}/ads/${ad.id}";
			FileUtils.writeByteArrayToFile(new File(path), event.file.contents);
		}
	}
	
	List<User> getHighestRatedUsersInInterval() {
		if (!from || !to) {
			return
		}
		
		/* TODO from - to értékek. csak akkor listázni ha ráér. első 10 legjobb értékelésűt visszaadni */
		return userService.findAll()
	}
}
