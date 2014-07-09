package hu.okfonok.services.impl;

import hu.okfonok.entities.Address
import hu.okfonok.services.GeocodingService

import org.springframework.stereotype.Service

import com.google.code.geocoder.Geocoder
import com.google.code.geocoder.GeocoderRequestBuilder
import com.google.code.geocoder.model.GeocodeResponse
import com.google.code.geocoder.model.GeocoderRequest

/**
 * https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=API_KEY
 * @author aacs
 *
 */
@Service
class GoogleGeocodingService implements GeocodingService{
	void asd(Address address) {
		Geocoder geocoder = new Geocoder("clientId","clientKey")
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address.toString()).setLanguage("hu").getGeocoderRequest()
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest)
		geocoderResponse.getResults()
	}
}
