import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.googleMaps.Geocoding;
import aiss.model.resources.GoogleMapsResource;





public class GoogleMapsResourceTest {
	static String direccion1, direccion2, direccion3;
	static GoogleMapsResource gmr = new GoogleMapsResource();
	
	
	
	private double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {

		final int R = 6371; // El radio de la tierra

		Double latDistance = Math.toRadians(lat2 - lat1);
		Double lonDistance = Math.toRadians(lon2 - lon1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // pasar a metros

		double height = el1 - el2;

		distance = Math.pow(distance, 2) + Math.pow(height, 2);

		return Math.sqrt(distance);
	}
	
	
	
	@BeforeClass
	public static void setup() throws Exception {
		
		
		direccion1 = "Campus Reina Mercedes, Sevilla";

		direccion2 = "Universidad de Sevilla";

		direccion3 = "Dos Hermanas, Sevilla";
		
	}
	
	
	
	
	
	@Test
	public void checkCoordenadas() throws Exception  {
		
		Geocoding g1 = gmr.getCoordenadas(direccion1);
		
		
	Double d1 =	g1.getResults().get(0).getGeometry().getLocation().getLat();
	Double d2 =	g1.getResults().get(0).getGeometry().getLocation().getLng();
	// Estos datos se han extraído de otras fuentes
		assertTrue(d1 > 37.358847 && d1 < 37.358849);
		assertTrue(d2 > -5.9869798 && d2 < -5.9869796);

	System.out.println(d1);
	System.out.println(d2);
	
	}
	
	@Test
	public void checkDistance() throws Exception {
		
		Geocoding g1 = gmr.getCoordenadas(direccion1);
		Geocoding g2 = gmr.getCoordenadas(direccion2);
		
		Double d1 =	g1.getResults().get(0).getGeometry().getLocation().getLat();
		Double d2 =	g1.getResults().get(0).getGeometry().getLocation().getLng();
		Double d3 =	g2.getResults().get(0).getGeometry().getLocation().getLat();
		Double d4 =	g2.getResults().get(0).getGeometry().getLocation().getLng();
		
		double distance = distance(d1,d3,d2,d4,0.,0.);
		// Estos datos se han extraído de otras fuentes
		assertTrue(distance > 2200 && distance < 2500);
		
		System.out.println(distance);
		
	}
	
	
	@Test
	public void checkRadio() throws Exception {
		
		Geocoding g1 = gmr.getCoordenadas(direccion1);
		
		Double d1 =	g1.getResults().get(0).getGeometry().getLocation().getLat();
		Double d2 =	g1.getResults().get(0).getGeometry().getLocation().getLng();
		Double d3 =	g1.getResults().get(0).getGeometry().getViewport().getSouthwest().getLat();
		Double d4 =	g1.getResults().get(0).getGeometry().getViewport().getSouthwest().getLng();
		
		double distance = distance(d1,d3,d2,d4,0.,0.);
		// Estos datos se han extraído de otras fuentes
		assertTrue(distance > 187 && distance < 192);
		
		System.out.println(distance);
		
	}
	
	
	
	
	
	
	
}
