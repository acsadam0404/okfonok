package hu.okfonok.beans

import hu.okfonok.entities.user.User

import javax.inject.Named

import org.springframework.context.annotation.Scope

@Named("employeeBean")
@Scope("view")
class EmployeeBean implements Serializable {
	private List<User> users;

	private User selectedUser;

	public EmployeeBean() {
		users = new ArrayList<User>();

		users.add(new User(userName: "tesztuser1" ));
		users.add(new User(userName: "tesztuser2" ));
		users.add(new User(userName: "tesztuser3" ));
	}

	public List<User> getUsers() {
		return users;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
}
