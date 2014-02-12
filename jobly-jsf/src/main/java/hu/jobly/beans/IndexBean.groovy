package hu.jobly.beans

import javax.inject.Named

import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("indexBean")
@Scope("session")
class IndexBean implements Serializable{
	boolean registrationFormVisible
}
