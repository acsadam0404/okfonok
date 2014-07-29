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

	void workingBtnAction() {
		userBean.user.profile.working = !userBean.user.profile.working
		saveUser()
	}

	void aboutBtnAction() {
		aboutEditing = !aboutEditing
		if (aboutEditing) {
			saveUser()
		}
	}

	void workingAction() {
		saveUser()
	}

	void saveUser() {
		userService.save(userBean.user)
	}
}
