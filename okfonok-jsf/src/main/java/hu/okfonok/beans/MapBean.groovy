package hu.okfonok.beans;

import hu.okfonok.services.GeocodingService
import javax.annotation.PostConstruct

import org.primefaces.model.map.DefaultMapModel
import org.primefaces.model.map.LatLng
import org.primefaces.model.map.MapModel
import org.primefaces.model.map.Marker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("session")
class MapBean {
	@Autowired
	private GeocodingService geocoder

	@Autowired
	private UserBean userBean

	private MapModel model

	MapBean() {
		/* dinamikusan hozzáadjuk a toPFLatLng metódust a könnyebb konvertáláshoz */
		com.google.code.geocoder.model.LatLng.metaClass.toPFLatLng = {->
			return new org.primefaces.model.map.LatLng(delegate.lat.doubleValue(), delegate.lng.doubleValue())
		}
		com.google.code.geocoder.model.LatLng.metaClass.toLatLngString = {->
			return delegate.lat.toString() + "," + delegate.lng.toString()
		}
	}

	MapModel getModel() {
		if (!model) {
			model = new DefaultMapModel()

			LatLng home = geocoder.toLatLng(userBean.user.address).toPFLatLng()
			model.addOverlay(new Marker(home, "Saját cím"));
		}
		return model;
	}

	String getCenter() {
		geocoder.toLatLng(userBean.user.address).toLatLngString()
	}
}
