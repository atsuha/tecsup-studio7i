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
import studio7i.modelo.Sala;
import studio7i.modelo.Servicio;
import studio7i.negocio.GestionLocal;
import studio7i.negocio.GestionSala;
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
		String metodo = request.getParameter("metodo");
		GestionLocal dao = new GestionLocal();
		GestionServicios negocio = new GestionServicios();
		RequestDispatcher rd;
		try {
			switch (metodo) {
			case "editar":
				String servicio_id = request.getParameter("servicio");
				Servicio servicio = negocio.obtener(Integer
						.parseInt(servicio_id));
				request.setAttribute("SERVICIO", servicio);
				request.setAttribute("LOCAL", dao.listar());
				rd = request.getRequestDispatcher("editarServicio.jsp");
				rd.forward(request, response);
				break;
			case "nuevo":
				request.setAttribute("LOCAL", dao.listar());
				rd = request.getRequestDispatcher("inscripcionServicio.jsp");
				rd.forward(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");

		String servicio_id = request.getParameter("txtServicio");
		String descripcion = request.getParameter("txtDescripcion");
		String local_id = request.getParameter("cboLocal");
		String precio_hora = request.getParameter("txtPrecioHora");
		GestionServicios negocio = new GestionServicios();
		RequestDispatcher rd = request
				.getRequestDispatcher("servicioIndex.jsp");

		try {
			switch (metodo) {
			case "listar":

				request.setAttribute("LISTA", negocio.listar());

				rd.forward(request, response);
				break;
			case "filtrar":
				String buscar = request.getParameter("buscar");

				request.setAttribute("LISTA",
						negocio.buscarPorDescripcion(buscar));

				rd.forward(request, response);
				break;
			case "editar":

				System.out.println(servicio_id + "" + descripcion + " "
						+ local_id + " " + precio_hora);
				try {

					negocio.actualizar(Integer.parseInt(servicio_id),
							descripcion, Double.parseDouble(precio_hora),
							Integer.parseInt(local_id));
					request.setAttribute("MENSAJE",
							"Se actualizó correctamente");
					request.setAttribute("LISTA",
							negocio.buscarPorDescripcion(""));
				} catch (DAOExcepcion e) {
					request.setAttribute("MENSAJE",
							"No se actualizó correctamente");
				}

				rd.forward(request, response);
				break;
			case "nuevo":
				
				System.out.println(servicio_id + "" + descripcion + " "
						+ local_id + " " + precio_hora);
				
				try {
					negocio.insertar(descripcion, Double.parseDouble(precio_hora),
							Integer.parseInt(local_id));
					request.setAttribute("MENSAJE",
							"Se registró correctamente");
					request.setAttribute("LISTA",
							negocio.buscarPorDescripcion(""));
					
				} catch (DAOExcepcion e) {
					request.setAttribute("MENSAJE",
							"No se registró correctamente");
				}
				
				rd.forward(request, response);
				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
