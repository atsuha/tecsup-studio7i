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

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Sala;
import studio7i.negocio.GestionSala;

/**
 * Servlet implementation class SalaServlet
 */
@WebServlet("/SalaServlet")
public class SalaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SalaServlet() {
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
		PrintWriter out = response.getWriter();
		Collection<Sala> resultado = new ArrayList<Sala>();
		try {
			switch (metodo) {
				case "listar": 
					resultado = listar();
					request.setAttribute("LISTA", resultado);
					RequestDispatcher rd = request.getRequestDispatcher("SalaIndex.jsp");
					rd.forward(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Collection<Sala> listar() throws DAOExcepcion{
		GestionSala dao = new GestionSala();
		return dao.lista();
	}

}
