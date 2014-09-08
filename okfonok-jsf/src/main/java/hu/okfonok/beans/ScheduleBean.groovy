//package hu.okfonok.beans;
//
//import javax.faces.application.FacesMessage
//import javax.faces.context.FacesContext
//import javax.faces.event.ActionEvent
//import javax.inject.Named
//
//import org.primefaces.event.ScheduleEntryMoveEvent
//import org.primefaces.event.ScheduleEntryResizeEvent
//import org.primefaces.event.SelectEvent
//import org.primefaces.model.DefaultScheduleEvent
//import org.primefaces.model.DefaultScheduleModel
//import org.primefaces.model.ScheduleEvent
//import org.primefaces.model.ScheduleModel
//import org.springframework.context.annotation.Scope
//
///**
// * 
// * @author Ács Ádám
// *
// */
//@org.springframework.stereotype.Component("scheduleBean")
//@Scope("session")
//class ScheduleBean implements Serializable {
//	ScheduleModel eventModel = new DefaultScheduleModel();
//	ScheduleEvent event = new DefaultScheduleEvent();
//	
//	  
//	public ScheduleEvent getEvent() {
//		return event;
//	}
//  
//	public void setEvent(ScheduleEvent event) {
//		this.event = event;
//	}
//	  
//	public void addEvent(ActionEvent actionEvent) {
//		if(event.getId() == null)
//			eventModel.addEvent(event);
//		else
//			eventModel.updateEvent(event);
//		  
//		event = new DefaultScheduleEvent();
//	}
//	  
//	public void onEventSelect(SelectEvent selectEvent) {
//		event = (ScheduleEvent) selectEvent.getObject();
//	}
//	  
//	public void onDateSelect(SelectEvent selectEvent) {
//		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
//	}
//	  
//	public void onEventMove(ScheduleEntryMoveEvent event) {
//		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
//		  
//		print message
//	}
//	  
//	public void onEventResize(ScheduleEntryResizeEvent event) {
//		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
//		  
//		print message
//	}
//}


