package hu.okfonok.beans

import hu.okfonok.services.UserService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("dataPageBean")
@Scope("session")
class DataPageBean {

	@Autowired
	private UserService userService

	@Autowired
	private UserBean userBean

	boolean dataEditing
	boolean aboutEditing

	void dataBtnAction() {
		dataEditing = !dataEditing
		if (dataEditing) {
			saveUser()
		}
	}

	String getDataBtnText() {
		if (!dataEditing) {
			return 'Adatok szerkesztése'
		}
		return 'Mentés'
	}


	void aboutBtnAction() {
		aboutEditing = !aboutEditing
		if (aboutEditing) {
			saveUser()
		}
	}
	
	String getAboutBtnText() {
		if (!aboutEditing) {
			return 'Szerkesztés'
		}
		return 'Mentés'
	}


	void workingAction() {
		saveUser()
	}

	void saveUser() {
		userService.save(userBean.user)
	}
}
