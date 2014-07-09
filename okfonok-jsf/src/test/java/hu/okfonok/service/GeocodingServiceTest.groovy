package hu.okfonok.service;

import static org.junit.Assert.*;

import hu.okfonok.services.GeocodingService
import hu.okfonok.services.impl.GoogleGeocodingService
import org.junit.Test;

class GeocodingServiceTest extends GroovyTestCase{
	
	void test() {
		GeocodingService s = new GoogleGeocodingService();
		s.asd();
	}
}
