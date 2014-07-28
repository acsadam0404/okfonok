package hu.okfonok.beans

import javax.inject.Named

import org.springframework.context.annotation.Scope

@org.springframework.stereotype.Component("addressBean")
@Scope("singleton")
class AddressBean implements Serializable{

	List<String> completeSettlement() {
		[
			"3000 - Hatvan",
			"3016 - Boldog",
			"3200 - Gyöngyös",
			"1111 - Budapest XI. kerület"] //TODO
	}
}
