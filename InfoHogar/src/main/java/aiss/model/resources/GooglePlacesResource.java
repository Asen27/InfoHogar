package aiss.model.resources;

import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.googlePlaces.NearbySearch;

public class GooglePlacesResource {
	
	private static final Logger log = Logger.getLogger(GoogleMapsResource.class.getName());
	private static final String GOOGLE_API_KEY = "AIzaSyA3JyTEq2uJu1gtlMJkRj6WZl8sIiwcE4c";

	public NearbySearch getLugaresCercanos (String coordenadas, String tipoLugar) {
		
		ClientResource cr = new ClientResource("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + coordenadas + "&type=" + tipoLugar + "&rankby=distance&key=" + GOOGLE_API_KEY);
		NearbySearch res = cr.get(NearbySearch.class);
		return res;
		
		
	}
	
	
	
	
	
	
	
	
}
