package hu.okfonok.beans

import hu.okfonok.entities.Settlement
import hu.okfonok.services.SettlementService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope

@org.springframework.stereotype.Component("addressBean")
@Scope("singleton")
class AddressBean implements Serializable{
	@Autowired
	private SettlementService service
	
	List<String> completeSettlement(String query) {
		List<Settlement> settlements = service.findBySettlementOrZipLike(query)
		List<String> result = settlements.collect {
			 it.zip + " - " + it.settlement 
		}
		
		return result
	}
}
