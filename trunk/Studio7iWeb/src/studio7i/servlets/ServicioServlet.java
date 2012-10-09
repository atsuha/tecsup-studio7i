package studio7i.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studio7i.dao.ServicioDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Servicio;
import studio7i.negocio.GestionServicios;

/**
 * Servlet implementation class ServicioServlet
 */
@WebServlet("/ServicioServlet")
public class ServicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServicioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		String servicio =  request.getParameter("servicio");
		

		try {
			switch (metodo) {
			case "listar":
				String descripcion = request.getParameter("descripcion");
				GestionServicios negocio = new GestionServicios();
				request.setAttribute("LISTA",
						negocio.buscarPorDescripcion(descripcion));

				RequestDispatcher rd = request
						.getRequestDispatcher("servicioIndex.jsp");
				rd.forward(request, response);
				break;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
