package hu.okfonok.beans

import javax.inject.Named

import org.springframework.context.annotation.Scope

@org.springframework.stereotype.Component("addressBean")
@Scope("singleton")
class AddressBean implements Serializable{

	List<String> completeStreet() {
		[
			"elm utca",
			"szabadság út",
			"pacsirtamező utca",
			"elm2 út",
			"elm2 út és még valami"] //TODO
	}
}
