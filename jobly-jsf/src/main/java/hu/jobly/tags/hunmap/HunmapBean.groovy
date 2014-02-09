package hu.jobly.tags.hunmap

import javax.inject.Named

import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@Named
@Scope("view")
class HunmapBean implements Serializable {
	String countyId
	HunmapCounty county;
	
	void setCountyId(String countyId) {
		this.countyId = countyId
		county = HunmapCounty.findByCountyId(countyId)
	}
}
