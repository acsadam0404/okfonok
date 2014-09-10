package hu.okfonok.beans

import hu.okfonok.entities.Advertisement
import hu.okfonok.services.AdvertisementService
import hu.okfonok.services.JobCategoryService
import hu.okfonok.services.UserService

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage
import javax.faces.event.ActionEvent

import org.primefaces.context.RequestContext
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

	private ScheduleModel eventModel;
	private ScheduleEvent event = new DefaultScheduleEvent();

	String post() {
		ad.user = userBean.user
		adService.save(ad)
		RequestContext.getCurrentInstance().execute("postadDialog.hide();")
		ad = new Advertisement()

		return 'index.xhtml?faces-redirect=true'
	}

	@PostConstruct
	public void init() {
		eventModel = new DefaultScheduleModel()
	}
	
	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject())
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta())

		addMessage(message)
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta())

		addMessage(message)
	}

	public ScheduleModel getEventModel() {
		return eventModel
	}

	public ScheduleEvent getEvent() {
		return event
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject()
	}
	
	public void addEvent(ActionEvent actionEvent) {
		if(event.getId() == null)
			eventModel.addEvent(event)
		else
			eventModel.updateEvent(event)

		event = new DefaultScheduleEvent()
	}
}
