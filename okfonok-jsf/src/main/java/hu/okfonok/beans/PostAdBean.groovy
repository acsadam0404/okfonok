package hu.okfonok.beans

import hu.okfonok.entities.JobCategory
import hu.okfonok.services.JobCategoryService

import javax.inject.Inject
import javax.inject.Named

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
	
	@Inject
	private JobCategoryService jcs
	
	def switchPhoneEdit() {
		phoneEdit = !phoneEdit
	}

	def phoneEdited() {
		if (phoneEditOnProfile) {
			println "phone edit a profilon és a hirdetésben"
		}
		else {
			println "phone edit a hirdetésben"
		}
	}
	
	def switchEmailEdit() {
		emailEdit = !emailEdit
	}

	def emailEdited() {
		if (emailEditOnProfile) {
			println "email edit a profilon és a hirdetésben"
		}
		else {
			println "email edit a hirdetésben"
		}
	}
	
	List<JobCategory> findSubByMainCategory() {
		if (mainCategory) {
			return jcs.findSubsByMain(mainCategory.id)
		}
		return []
	}
}
