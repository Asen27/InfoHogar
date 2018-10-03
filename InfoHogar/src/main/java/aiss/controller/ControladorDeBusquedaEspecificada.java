package aiss.controller;

import java.io.IOException;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import aiss.model.idealista.ElementList;
import aiss.model.idealista.PropertySearch;
import aiss.model.idealistaToken.IdealistaTokenRequest;
import aiss.model.idealistaToken.Token;
import aiss.model.resources.IdealistaResource;

public class ControladorDeBusquedaEspecificada extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ControladorDeBusquedaEspecificada.class.getName());

	public ControladorDeBusquedaEspecificada() {
		super();
	}

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

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		RequestDispatcher rd = null;

		IdealistaTokenRequest tokenRequest = new IdealistaTokenRequest();
		Token token = tokenRequest.getToken();

		if (token != null) {

			Map<String, String> requisitos = new HashMap<String, String>();

			// ------ Parámetros comunes para todas las búsquedas
			
			requisitos.put("operation", req.getParameter("copiaBusqueda"));
			requisitos.put("propertyType", req.getParameter("copiaTipoAnuncio"));

			String center = req.getParameter("latitud") + "," + req.getParameter("longitud");
			requisitos.put("center", center);

			Double distance = this.distance(Double.valueOf(req.getParameter("latitud")),
					Double.valueOf(req.getParameter("latitudPuntoMasSudoeste")),
					Double.valueOf(req.getParameter("longitud")),
					Double.valueOf(req.getParameter("longitudPuntoMasSudoeste")), 0., 0.);
			Integer distancia = new Integer(distance.intValue());
			requisitos.put("distance", distancia.toString());

			if (req.getParameterMap().containsKey("precioMin")) {
				requisitos.put("minPrice", req.getParameter("precioMin"));
			}

			if (req.getParameterMap().containsKey("precioMax")) {
				requisitos.put("maxPrice", req.getParameter("precioMax"));
			}
			
			if (req.getParameterMap().containsKey("filtros")) {
				String[] filtros = req.getParameterValues("filtros");
				for (int i = 0; i < filtros.length; i++) {
					requisitos.put(filtros[i], "true");
				}
			}
			
			String viv = "";

			// -------------- Parámetros para búsqueda de viviendas

			if (req.getParameter("copiaTipoAnuncio").equals("homes")) {

				if (req.getParameterMap().containsKey("tamMin")) {
					requisitos.put("minSize", req.getParameter("tamMin"));
				}

				if (req.getParameterMap().containsKey("tamMax")) {
					requisitos.put("maxSize", req.getParameter("tamMax"));
				}

				if (req.getParameterMap().containsKey("tiposVivienda")) {
					switch (req.getParameter("tiposVivienda")) {
					default:
						requisitos.put("flat", "true");
						viv = "Piso";
						break;
					case "penthouse":
						requisitos.put("penthouse", "true");
						viv="Ático";
						break;
					case "duplex":
						requisitos.put("duplex", "true");
						viv="Dúplex";
						break;
					case "studio":
						requisitos.put("studio", "true");
						viv="Estudio";
						break;
					case "chalet":
						requisitos.put("chalet", "true");
						viv="Chalet";
						break;
					case "countryHouse":
						requisitos.put("countryHouse", "true");
						viv="Casa rústica";
						break;
					}
				}

				if (req.getParameterMap().containsKey("habitaciones")) {
					String habitaciones = "";

					String[] hab = req.getParameterValues("habitaciones");
					for (int i = 0; i < hab.length; i++) {
						habitaciones += hab[i] + ",";
					}

					habitaciones = habitaciones.substring(0, habitaciones.length() - 1);

					requisitos.put("bedrooms", habitaciones);
				}

				if (req.getParameterMap().containsKey("banos")) {
					String baños = "";

					String[] ban = req.getParameterValues("banos");
					for (int i = 0; i < ban.length; i++) {
						baños += ban[i] + ",";
					}

					baños = baños.substring(0, baños.length() - 1);

					requisitos.put("bedrooms", baños);
				}

				
	
				// -------------- Parámetros para búsqueda de habitaciones
				
			} else if (req.getParameter("copiaTipoAnuncio").equals("bedrooms")) {
				viv="Piso";
				requisitos.put("newGender", req.getParameter("sexo"));
				
				
				
				
				if (req.getParameterMap().containsKey("fumar")) {
					if (req.getParameter("fumar").equals("valorNeutro")) {
					} else {
						requisitos.put("smokePolicy", req.getParameter("fumar"));
					}	
				}
				
				if (req.getParameterMap().containsKey("personas")) {
					String personas = "";

					String[] compañeros = req.getParameterValues("personas");
					for (int i = 0; i < compañeros.length; i++) {
						personas += compañeros[i] + ",";
					}

					personas = personas.substring(0, personas.length() - 1);

					requisitos.put("housemates", personas);
				}
				
				if (req.getParameterMap().containsKey("mascotas")) {
					if (req.getParameter("mascotas").equals("valorNeutro")) {
					} else {
						requisitos.put("petsPolicy", req.getParameter("mascotas"));
					}	
				}
				
			
				
				// -------------- Parámetros para búsqueda de oficinas
			}  else if (req.getParameter("copiaTipoAnuncio").equals("offices")) {
				viv="Oficina";
				
				if (req.getParameterMap().containsKey("tipoEdificio")) {
					if (req.getParameter("tipoEdificio").equals("valorNeutro")) {
					} else {
						requisitos.put("buildingType", req.getParameter("tipoEdificio"));
					}	
				}
				
				if (req.getParameterMap().containsKey("distribucion")) {
					if (req.getParameter("distribucion").equals("valorNeutro")) {
					} else {
						requisitos.put("layout", req.getParameter("distribucion"));
					}	
				}
				
				if (req.getParameterMap().containsKey("tamMin")) {
					requisitos.put("minSize", req.getParameter("tamMin"));
				}

				if (req.getParameterMap().containsKey("tamMax")) {
					requisitos.put("maxSize", req.getParameter("tamMax"));
				}
				
				// -------------- Parámetros para búsqueda de garajes
				
			} else if (req.getParameter("copiaTipoAnuncio").equals("garages")) {
				viv="Garaje";
				
		
				
				// -------------- Parámetros para búsqueda de locales
			} else {
				viv="Local";
				if (req.getParameterMap().containsKey("tipo")) {
					
					String tipos = "";

					String[] t = req.getParameterValues("tipo");
					for (int i = 0; i < t.length; i++) {
						tipos += t[i] + ",";
					}

					tipos = tipos.substring(0, tipos.length() - 1);

					requisitos.put("buildingTypes", tipos);
					
				}
				
				if (req.getParameterMap().containsKey("tamMin")) {
					requisitos.put("minSize", req.getParameter("tamMin"));
				}

				if (req.getParameterMap().containsKey("tamMax")) {
					requisitos.put("maxSize", req.getParameter("tamMax"));
				}
		
				if (req.getParameterMap().containsKey("ubicacion")) {
					requisitos.put("location", req.getParameter("ubicacion"));
				}
				
		
				
			}

		
				
			
			

			IdealistaResource idealista = new IdealistaResource();
			String acceso = token.getAccessToken();
			PropertySearch anuncios = idealista.getAnuncios(requisitos, acceso);

			if (anuncios != null) {

				List<ElementList> resultados = anuncios.getElementList();

				req.setAttribute("anuncios", resultados);
				req.setAttribute("tipoDeAnuncio", viv);
				req.setAttribute("numAnuncios", anuncios.getTotal());
				
				
				rd = req.getRequestDispatcher("/listaDeAnuncios.jsp");

			} else {
				req.setAttribute("error", "Error al obtener los anuncios de Idealista");
				rd = req.getRequestDispatcher("/error.jsp");
			}

		} else {
			req.setAttribute("error", "Error al obtener el token");
			rd = req.getRequestDispatcher("/error.jsp");
		}

		rd.forward(req, resp);

	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
