package studio7i.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Reserva;
import studio7i.modelo.Sala;
import studio7i.negocio.GestionLocal;
import studio7i.negocio.GestionPersona;
import studio7i.negocio.GestionReserva;
import studio7i.negocio.GestionSala;
import studio7i.negocio.GestionServicios;


/**
 * Servlet implementation class reservaServlet
 */
@WebServlet("/reservaServlet")
public class reservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		Collection<Reserva> resultado = new ArrayList<Reserva>();
		Collection<Sala> salas = new ArrayList<Sala>();
		
		GestionSala	dao = new GestionSala();
		GestionReserva negocio = new GestionReserva();
		
		try {
			switch (metodo) {
				case "listar": 
					resultado = listar();
					request.setAttribute("RESULTADO", resultado);
					RequestDispatcher rd = request.getRequestDispatcher("consultarReservas.jsp");
					rd.forward(request, response);
					break;
				case "buscarPorFechaYSala":
					String fecha = request.getParameter("txtFecha");
					int sala_id = Integer.parseInt(request.getParameter ("txtSala"));
					resultado = buscarPorFechaYSala(fecha, sala_id);
					request.setAttribute("RESULTADO", resultado);
					request.setAttribute("fecha", fecha); // devuelve la fecha seleccionada previamente
					request.setAttribute("sala", sala_id); // devuelve la sala seleccionada previamente
					salas = listarSalas(); 
					request.setAttribute("LISTA", salas); // para poblar la lista de salas en el combo
					RequestDispatcher rd1 = request.getRequestDispatcher("consultarReservas.jsp");
					rd1.forward(request, response);
					break;					
					
				case "nuevo":
					request.setAttribute("SALA", dao.lista());
					rd = request.getRequestDispatcher("reservasala.jsp");
					rd.forward(request, response);
					break;
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		
		
		String sala_id = request.getParameter("cboSala");
		String persona_id = request.getParameter("cboPersona");
		String fecha = request.getParameter("txtFecha");
		String hora_inicio = request.getParameter("txtInicio");
		String hora_fin = request.getParameter("txtFin");
		
		GestionReserva negocio = new GestionReserva();
		RequestDispatcher rd = request
				.getRequestDispatcher("servicioIndex.jsp");
		
		try {
			switch (metodo) {
			
			case "nuevo":									
				System.out.println(sala_id+" "+persona_id+" "+fecha+" "+hora_inicio+" "+hora_fin);
				negocio.insertar1(Integer.parseInt(hora_inicio), Date.parse(fecha), Integer.parseInt(hora_fin), 1, Integer.parseInt(sala_id), Integer.parseInt(persona_id));
				break;
						
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}	
	
	public Collection<Reserva> listar() throws DAOExcepcion{
		GestionReserva dao = new GestionReserva();
		return dao.listar();
	}
	
	public Collection<Reserva> buscarPorFechaYSala(String fecha, int sala_id) throws DAOExcepcion{
		GestionReserva dao = new GestionReserva();
		return dao.buscarPorFechaYSala(fecha, sala_id);
		//return dao.buscarPorFechaYSala("2012-10-11", 2);
	}
	
	public Collection<Sala> listarSalas() throws DAOExcepcion{
		GestionSala dao = new GestionSala();
		return dao.lista();
	}


}
