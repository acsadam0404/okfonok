package hu.okfonok.tags.hunmap;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Ács Ádám
 *
 */
public enum HunmapCounty {
	GYOR_MOSON_SOPRON("gyms"),
	KOMAROM_ESZTERGOM("ke");
	
	
	private String countyId;

	private HunmapCounty(String countyId) {
		this.countyId = countyId;
	}
	
	public static HunmapCounty findByCountyId(String countyId) {
		for (HunmapCounty county : values()) {
			if (StringUtils.equalsIgnoreCase(county.countyId, countyId)) {
				return county;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return countyId;
	}
}
