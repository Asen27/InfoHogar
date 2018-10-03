import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;


import aiss.model.googlePlaces.NearbySearch;
import aiss.model.resources.GooglePlacesResource;





public class GooglePlacesResourceTest {
	static String coordenadas;
	static String lugar;
	static GooglePlacesResource gpr = new GooglePlacesResource();
	
	

	
	
	
	@BeforeClass
	public static void setup() throws Exception {
		
		coordenadas = "37.3588486,-5.9869797";
		

		lugar = "pharmacy";

		
		
	}
	
	
	
	
	
	@Test
	public void checkCoordenadas()  {
		
		NearbySearch ns1 = gpr.getLugaresCercanos(coordenadas, lugar);
		
		// Las coordenadas introducidas son las del campus Reina Mercedes
		// La farmacia "Rosario Núñez Valdes" está muy cerda del campus Reina Mercedes
		
		List<String> farmacias = new ArrayList<>();
		
		for (int i=0; i < 5; i++) {
		String s1 = ns1.getResults().get(i).getName();
		farmacias.add(s1);
		}		
		
		String o1 = "Rosario Núñez Valdes";
		String o2 = "Rosario Nuñez Valdes";
		String o3 = "ROSARIO NÚÑEZ VALDES";
		String o4 = "ROSARIO NUÑEZ VALDES";
		String o5 = "rosario núñez valdes";
		String o6 = "rosario nuñez valdes";
		
		assertTrue(farmacias.contains(o1) || 
				farmacias.contains(o2) || 
				farmacias.contains(o3) || 
				farmacias.contains(o4) ||
				farmacias.contains(o5) ||
				farmacias.contains(o6) );
		
		


	
	}
	

	
	
	
	
	
	
	
}
