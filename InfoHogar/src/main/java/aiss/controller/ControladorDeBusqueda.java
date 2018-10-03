package aiss.controller;


import java.io.IOException;

import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.googleMaps.Geocoding;
import aiss.model.googleMaps.Geometry;
import aiss.model.resources.GoogleMapsResource;


public class ControladorDeBusqueda extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ControladorDeBusqueda.class.getName());
	
	public ControladorDeBusqueda() {
		super();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		RequestDispatcher rd = null;
		
		String direccion = req.getParameter("direccion");
		
		GoogleMapsResource googleMaps = new GoogleMapsResource();
		Geocoding geocoding = googleMaps.getCoordenadas(direccion);
		
		if (geocoding !=null) {
		/*  Hemos decidido sacar únicamente el primer resultado de la lista obtenida por el
		    método getResults() visto que en la documentación de la GoogleMaps Geocoding API pone:
			"Generally, only one entry in the "results" array is returned for address lookups,
		    though the geocoder may return several results when address queries are ambiguous."
		*/	Geometry coordenadas = geocoding.getResults().get(0).getGeometry();
			req.setAttribute("latitud", coordenadas.getLocation().getLat());
			req.setAttribute("longitud", coordenadas.getLocation().getLng());
		// Para realizar una operación de consulta y obtener los anuncios correspondientes a una dirección dada,
		// la API de Idealista requiere que se pasen los parámetros center y distance.
		// Necesitaremos que GoogleMaps devuelva tanto las coordenadas del centro de la zona (el parámetro center)
		// como las coordenadas del punto más sudoeste de la zona. Después tendrémos que implementar 
		//	una función que calcule la distancia entre los dos puntos (el parámetro distance) 
			req.setAttribute("latitudPuntoMasSudoeste", coordenadas.getViewport().getSouthwest().getLat());
			req.setAttribute("longitudPuntoMasSudoeste", coordenadas.getViewport().getSouthwest().getLng());


	    String tipoAnuncio = req.getParameter("tipoAnuncio");
	    
	    switch (tipoAnuncio) {
	    	default:
	    		rd = req.getRequestDispatcher("/buscadorViviendas.jsp");
	    		break;
	    	case "bedrooms":
		    	rd = req.getRequestDispatcher("/buscadorHabitaciones.jsp");
		    	break;
	    	case "offices":
		    	rd = req.getRequestDispatcher("/buscadorOficinas.jsp");
		    	break;
	    	case "garages":
		    	rd = req.getRequestDispatcher("/buscadorGarajes.jsp");
		    	break;
	    	case "premises":
		    	rd = req.getRequestDispatcher("/buscadorLocales.jsp");
		    	break;
	    }
		
		String busqueda = req.getParameter("busqueda");
		req.setAttribute("busqueda", busqueda);		
			
		
		} else {
			req.setAttribute("error", "Error al obtener las coordenadas de GoogleMaps");
			rd = req.getRequestDispatcher("/error.jsp");
		}
		
		
		
		rd.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doGet(req, resp);
	}
	
}
