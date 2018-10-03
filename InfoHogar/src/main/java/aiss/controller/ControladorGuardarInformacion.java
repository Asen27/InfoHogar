package aiss.controller;

import java.io.IOException;

import java.util.logging.Logger;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.googleDrive.FileItem;
import aiss.model.resources.GoogleDriveResource;



public class ControladorGuardarInformacion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ControladorGuardarInformacion.class.getName());
	
	
	public ControladorGuardarInformacion() {
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String token = (String) req.getSession().getAttribute("GoogleDrive-token");
		
		

		if (token != null && !"".equals(token)) {
			String direccion = req.getParameter("direccion");
			String nombre  = "InfoHogar: " + direccion;
			if (direccion == null || "".equals(direccion)) {
				nombre = "InfoHogar: " + req.getParameter("municipio");
			}
			
			if(nombre!=null && !"".equals(nombre)){
				
				
				String anuncio = req.getParameter("anuncio");
				String precio = req.getParameter("precio"); 
				
				String baños = req.getParameter("baños");
				String provincia = req.getParameter("provincia");
				String municipio = req.getParameter("municipio");
				String comarca = req.getParameter("comarca");
				String obraNueva = req.getParameter("obraNueva");
				String habitaciones = req.getParameter("habitaciones");
				String tamaño = req.getParameter("tamaño");
				String url = req.getParameter("url");
				String operacion = req.getParameter("operacion");
				

				String contenido = "Se";
				if (operacion.equals("sale")) {
					contenido += " vende ";
				} else {
					contenido += " alquila ";
				}
				
				contenido += anuncio + " en " + direccion + "\n";
				
				contenido += "Municipio: " + municipio + "\n";
				
				if (comarca != null && !"".equals(comarca)) {
					contenido += "Comarca: " + comarca + "\n";
				}
				
				contenido += "Provincia: " + provincia + "\n";
				
				contenido += "Precio: " + precio + "\n";
				
				
				if (tamaño != null && !"".equals(tamaño)) {
					contenido += "Tamaño: " + tamaño + "\n";
				}
				
				if (habitaciones != null && !"".equals(habitaciones) && !"0".equals(habitaciones)) {
					contenido += "Tiene " + habitaciones + " habitaciones" + "\n";
				}
				
				if (baños != null && !"".equals(baños) && !"0".equals(baños)) {
					contenido += "Tiene " + baños + " baños.";
				}
				
				contenido += "\n";
				
				
				if (obraNueva.equals("true")) {
					contenido += "Es obra nueva." + "\n";
				}
				
				contenido += "Para ver más información sobre este anuncio, entre en la siguiente página web: " + url;
				
				
				GoogleDriveResource googleDrive=new GoogleDriveResource(token);
				FileItem fichero = new FileItem();
				fichero.setTitle(nombre);
				fichero.setMimeType("text/plain");
				String ret = googleDrive.crearFichero(fichero, contenido);
				
				if (ret != null) {
					req.setAttribute("mensaje", "Se ha guardado un fichero con la información correspondiente a este anuncio.");
					req.getRequestDispatcher("/googleDrive.jsp").forward(req,resp);
				} else {
					req.setAttribute("error", "Se ha producido error al intentar crear el fichero");
					req.getRequestDispatcher("/error.jsp").forward(req, resp);
				}
				
			}else{
				req.setAttribute("error", "Еrror al crear el fichero. El fichero no tiene nombre");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
			
	
			
		} else {
			req.setAttribute("direccion", req.getParameter("direccion"));
			req.setAttribute("nombre", req.getParameter("nombre"));
			req.setAttribute("anuncios", req.getParameter("anuncios"));
			req.setAttribute("precio", req.getParameter("precio"));
			req.setAttribute("baños", req.getParameter("baños"));
			req.setAttribute("provincia", req.getParameter("provincia"));
			req.setAttribute("municipio", req.getParameter("municipio"));
			req.setAttribute("comarca", req.getParameter("comarca"));
			req.setAttribute("obraNueva", req.getParameter("obraNueva"));
			req.setAttribute("habitaciones", req.getParameter("habitaciones"));
			req.setAttribute("tamaño", req.getParameter("tamaño"));
			req.setAttribute("url", req.getParameter("url"));
			req.setAttribute("operation", req.getParameter("operation"));
			
			
			
			
			
			req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
		}
		
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
