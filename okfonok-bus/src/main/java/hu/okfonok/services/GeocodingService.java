package hu.okfonok.services;

import com.google.code.geocoder.model.LatLng;

import hu.okfonok.entities.Address;

public interface GeocodingService {
	LatLng toLatLng(Address address);
}
