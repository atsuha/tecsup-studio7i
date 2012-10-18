package studio7i.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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
		try {
			switch (metodo) {
				case "listar": 
					personas = listar();
					request.setAttribute("RESULTADO", personas);
					RequestDispatcher rd = request.getRequestDispatcher(""); // modificar jsp quien lo necesite.
					rd.forward(request, response);
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

}
