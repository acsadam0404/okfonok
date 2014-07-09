package hu.okfonok.beans

import javax.faces.event.ValueChangeEvent

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("dataPageBean")
@Scope("session")
class DataPageBean {
	boolean readonly = true
	
	void edit() {
		readonly = !readonly
	}
}
