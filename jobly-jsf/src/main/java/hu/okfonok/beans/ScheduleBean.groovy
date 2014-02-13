package hu.okfonok.beans;

import javax.inject.Named

import org.primefaces.model.DefaultScheduleEvent
import org.primefaces.model.DefaultScheduleModel
import org.primefaces.model.ScheduleEvent
import org.primefaces.model.ScheduleModel
import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("scheduleBean")
@Scope("session")
class ScheduleBean implements Serializable {
	final ScheduleModel eventModel = new DefaultScheduleModel();
}
