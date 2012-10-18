package studio7i.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import studio7i.modelo.Persona;
import studio7i.negocio.GestionPersona;

/**
 * Servlet implementation class PersonaServlet
 */
@WebServlet("/PersonaServlet")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
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
		Collection<Persona> personas = new ArrayList<Persona>();
		Persona persona = null;
		String idPersona = request.getParameter("idPersona");
		String dni = request.getParameter("dni");
		String nombres = request.getParameter("nombres");
		String paterno = request.getParameter("paterno");
		String materno = request.getParameter("materno");
		String email = request.getParameter("email");
		String fecha_nacimiento = request.getParameter("fecha_nacimiento")  ;
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String rol = request.getParameter("rol");
		
	    // *** convertir fecha string a date *** //
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd"); 
	    Date fecha_nac = null;
		try {
			fecha_nac = dateFormat.parse(fecha_nacimiento);
		} catch (ParseException e1) {
			e1.printStackTrace();
		} 
		
		try {
			switch (metodo) {
				case "listar": 
					personas = listar();
					request.setAttribute("RESULTADO", personas);
					RequestDispatcher rd = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd.forward(request, response);
					break;
				case "obtener":
					persona = obtener(Integer.parseInt(idPersona));
					request.setAttribute("RESULTADO", persona);
					RequestDispatcher rd1 = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd1.forward(request, response);
					break;						
				case "insertar": 
					persona = insertar(dni, nombres, paterno, materno, email, fecha_nac, usuario, password, rol);
					request.setAttribute("RESULTADO", persona);
					RequestDispatcher rd2 = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd2.forward(request, response);
					break;
				case "eliminar": 
					eliminar(Integer.parseInt(idPersona));
					RequestDispatcher rd3 = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd3.forward(request, response);
					break;					
				case "buscarPorDNI": 
					personas = buscarPorDNI(dni);
					request.setAttribute("RESULTADO", personas);
					RequestDispatcher rd4 = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd4.forward(request, response);
					break;
				case "actualizar": 
					persona = actualizar(Integer.parseInt(idPersona), dni, nombres, paterno, materno, email, fecha_nac, usuario, password, rol);
					request.setAttribute("RESULTADO", persona);
					RequestDispatcher rd5 = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd5.forward(request, response);
					break;					
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Collection<Persona> listar() throws DAOExcepcion{
		GestionPersona dao = new GestionPersona();
		return dao.listar();
	}
	
	public Persona obtener(int idPersona) throws DAOExcepcion{
		GestionPersona dao = new GestionPersona();
		return dao.obtener(idPersona);
	}
	
	public Persona insertar(String dni, String nombres, String paterno, String materno, String email, Date fecha_nacimiento, String usuario, String password, String rol) throws DAOExcepcion{
		GestionPersona dao = new GestionPersona();
		return dao.insertar(dni, nombres, paterno, materno, email, fecha_nacimiento, usuario, password, rol);
	}
	
	public void eliminar(int idPersona) throws DAOExcepcion{
		GestionPersona dao = new GestionPersona();
		dao.eliminar(idPersona);
	}
	
	public Collection<Persona> buscarPorDNI(String dni) throws DAOExcepcion{
		GestionPersona dao = new GestionPersona();
		return dao.buscarPorDNI(dni);
	}
	
	public Persona actualizar(int idPersona, String dni, String nombres, String paterno, String materno, String email, Date fecha_nacimiento, String usuario, String password, 
			String rol) throws DAOExcepcion{
		GestionPersona dao = new GestionPersona();
		return dao.actualizar(idPersona, dni, nombres, paterno, materno, email, fecha_nacimiento, usuario, password, rol);
	}

}
