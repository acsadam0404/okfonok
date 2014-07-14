package hu.okfonok.beans

import hu.okfonok.entities.user.User

import javax.inject.Named

import org.springframework.context.annotation.Scope

@org.springframework.stereotype.Component("employeeBean")
@Scope("view")
class EmployeeBean implements Serializable {
}
