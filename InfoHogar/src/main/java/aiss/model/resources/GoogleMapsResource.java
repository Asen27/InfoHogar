package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;


import org.restlet.resource.ClientResource;

import aiss.model.googleMaps.Geocoding;


public class GoogleMapsResource {
	private static final String GOOGLE_API_KEY = "AIzaSyA3JyTEq2uJu1gtlMJkRj6WZl8sIiwcE4c";
	private static final Logger log = Logger.getLogger(GoogleMapsResource.class.getName());
	
	

	public Geocoding getCoordenadas(String direccion) throws UnsupportedEncodingException {
	
		String query = direccion.replace(","," ").replace(".", " ").replace("  ", " ");
		String direccionCodificada = URLEncoder.encode(query, "UTF-8");
		ClientResource cr = new ClientResource("https://maps.googleapis.com/maps/api/geocode/json?address=" + direccionCodificada + "&region=es&key=" + GOOGLE_API_KEY); 
		
		Geocoding res = cr.get(Geocoding.class);
	    return res;
	}
	
	
	
	
}
