  package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.googlePlaces.NearbySearch;
import aiss.model.googlePlaces.Result;
import aiss.model.resources.GooglePlacesResource;

public class ControladorDeBusquedaLugaresCercanos extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ControladorDeBusquedaLugaresCercanos.class.getName());

	
	public ControladorDeBusquedaLugaresCercanos() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		RequestDispatcher rd = null;
		
		String lugar = req.getParameter("lugar");
		String coordenadas = req.getParameter("coordenadas");
		
		GooglePlacesResource googlePlaces = new GooglePlacesResource();
		NearbySearch resultados = googlePlaces.getLugaresCercanos(coordenadas, lugar);
		
		if (resultados != null) {
			
			List<Result> lugaresCercanos = resultados.getResults();
			req.setAttribute("lugaresCercanos", lugaresCercanos);
			rd = req.getRequestDispatcher("/lugaresCercanos.jsp");
			
		} else {
			
			req.setAttribute("error", "Error al obtener los lugares cercanos de GooglePlaces");
			rd = req.getRequestDispatcher("/error.jsp");
		}
		
		rd.forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
