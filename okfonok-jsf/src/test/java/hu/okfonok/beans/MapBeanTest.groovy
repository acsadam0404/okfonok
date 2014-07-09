package hu.okfonok.beans;

import org.junit.Test
import org.primefaces.model.map.LatLng

class MapBeanTest extends GroovyTestCase {
	
	@Test
	void testLatLngConvert() {
		new MapBean()
		LatLng l = new com.google.code.geocoder.model.LatLng(1, 2).toPFLatLng()
		assert l.lat == 1.0d
		assert l.lng == 2.0d
	}
	
	@Test
	void testLatLngString() {
		new MapBean()
		String l = new com.google.code.geocoder.model.LatLng(1, 2).toLatLngString()
		assert l == '1,2' 
		
		String l2 = new com.google.code.geocoder.model.LatLng(1.11111, 2.11111).toLatLngString()
		assert l2 == '1.11111,2.11111'
	}
	
}
