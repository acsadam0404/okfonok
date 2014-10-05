package hu.okfonok.beans

import hu.okfonok.entities.Advertisement
import hu.okfonok.services.AdvertisementService
import hu.okfonok.services.JobCategoryService
import hu.okfonok.services.UserService

import javax.faces.context.FacesContext
import javax.servlet.ServletContext

import org.apache.commons.io.FileUtils
import org.primefaces.context.RequestContext
import org.primefaces.event.FileUploadEvent
import org.primefaces.event.ScheduleEntryMoveEvent
import org.primefaces.event.ScheduleEntryResizeEvent
import org.primefaces.event.SelectEvent
import org.primefaces.model.DefaultScheduleEvent
import org.primefaces.model.DefaultScheduleModel
import org.primefaces.model.ScheduleEvent
import org.primefaces.model.ScheduleModel
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

	ScheduleModel eventModel = new DefaultScheduleModel()
	ScheduleEvent event = new DefaultScheduleEvent()

	String post() {
		ad.user = userBean.user
		adService.save(ad)
		RequestContext.getCurrentInstance().execute("postadDialog.hide();")
		ad = new Advertisement()

		return 'index.xhtml?faces-redirect=true'
	}

	void onDateSelect(SelectEvent selectEvent) {
		//TODO legyen valami név?
		event = new DefaultScheduleEvent("TODO legyen ennek valami neve?", (Date) selectEvent.getObject(), (Date) selectEvent.getObject())
		addEvent(event)
	}

	void onEventMove(ScheduleEntryMoveEvent event) {
		print event
		//TODO eltárolni adatbébe
	}

	void onEventResize(ScheduleEntryResizeEvent event) {
		print event
		//TODO eltárolni adatbébe
	}
	
	private void addEvent(ScheduleEvent event) {
		if(event.getId() == null) {
			eventModel.addEvent(event)
		}
		else {
			eventModel.updateEvent(event)
		}
	}
	
	void specifiedJobTimeBtnAction() {
		ad.specifiedJobTime = !ad.specifiedJobTime;
	}
	
	void homeWorkBtnAction() {
		ad.homework = !ad.homework;
	}
	
	void handleFileUpload1(FileUploadEvent event) {
		handleFileUpload(event, 1)
	}
	
	void handleFileUpload2(FileUploadEvent event) {
		handleFileUpload(event, 2)
	}
	
	void handleFileUpload3(FileUploadEvent event) {
		handleFileUpload(event, 3)
	}
	
	void handleFileUpload4(FileUploadEvent event) {
		handleFileUpload(event, 4)
	}
	
	void handleFileUpload5(FileUploadEvent event) {
		handleFileUpload(event, 5)
	}
	
	void handleFileUpload(FileUploadEvent event, int fileNumber) {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()
		FileUtils.writeByteArrayToFile(new File("${servletContext.getRealPath('')}/${getImagePath(fileNumber)}"), event.file.contents)
		
		ad."setImagePath${fileNumber}"(getImagePath(fileNumber))
		RequestContext.getCurrentInstance().update("postadForm:postadImages")
	}

	void deleteFile(int fileNumber) {
		new File(getImagePath(fileNumber)).delete()
	}
	
	String getImagePath(int fileNumber) {
		return "users/${userBean.user.userName}/ads/${ad.id}/${fileNumber}"
	}
}
