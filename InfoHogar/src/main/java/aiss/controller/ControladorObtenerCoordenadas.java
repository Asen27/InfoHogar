package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorObtenerCoordenadas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ControladorObtenerCoordenadas.class.getName());

	public ControladorObtenerCoordenadas() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = null;

		String latitud = req.getParameter("latitud");
		String longitud = req.getParameter("longitud");

		if (latitud != null && longitud != null) {
			String coordenadas = latitud + "," + longitud;
			req.setAttribute("coordenadas", coordenadas);
			rd = req.getRequestDispatcher("/lugaresCercanos.jsp");
		} else {

			req.setAttribute("error", "Error al obtener las coordenadas de Idealista");
			rd = req.getRequestDispatcher("/error.jsp");

		}

		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
