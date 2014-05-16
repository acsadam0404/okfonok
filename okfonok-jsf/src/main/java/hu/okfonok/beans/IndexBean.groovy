package hu.okfonok.beans

import hu.okfonok.entities.user.User
import hu.okfonok.services.UserService

import javax.annotation.PostConstruct

import org.primefaces.push.PushContext
import org.primefaces.push.PushContextFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component("indexBean")
@Scope("view")
class IndexBean implements Serializable{
	boolean registrationFormVisible

	List<User> employees
	User emp1
	User emp2
	int currentIndex

	@Autowired
	private UserService userService

	@PostConstruct
	void init() {
		employees = userService.findAll()
		emp1 = employees[0]
		emp2 = employees[1]
	}


	void pushEmployees() {
		currentIndex = currentIndex < (employees.size() - 1) ? currentIndex + 1 : 0
		emp1 = employees[currentIndex]
		currentIndex = currentIndex < (employees.size() - 1) ? currentIndex + 1 : 0
		emp2 = employees[currentIndex]

		PushContext pushContext = PushContextFactory.getDefault().getPushContext();
		pushContext.push("/employees", "test")
	}
}
