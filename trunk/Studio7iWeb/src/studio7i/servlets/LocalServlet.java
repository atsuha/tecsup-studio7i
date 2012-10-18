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
import studio7i.modelo.Local;
import studio7i.negocio.GestionLocal;


/**
 * Servlet implementation class LocalServlet
 */
@WebServlet("/LocalServlet")
public class LocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocalServlet() {
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
		Collection<Local> locales = new ArrayList<Local>();
		try {
			switch (metodo) {
				case "listar": 
					locales = listar();
					request.setAttribute("RESULTADO", locales);
					RequestDispatcher rd = request.getRequestDispatcher(""); // modificar jsp quien lo necesite.
					rd.forward(request, response);
					break;				
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public Collection<Local> listar() throws DAOExcepcion{
		GestionLocal dao = new GestionLocal();
		return dao.listar();
	}
}
