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
import studio7i.modelo.Evento;
import studio7i.negocio.GestionEvento;

/**
 * Servlet implementation class EventoServlet
 */
@WebServlet("/EventoServlet")
public class EventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EventoServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String metodo = request.getParameter("metodo");
			PrintWriter out = response.getWriter();
			Collection<Evento> resultado = new ArrayList<Evento>();
			try{
				switch(metodo){
				case "listar":
					resultado = listar();
					request.setAttribute("lista", resultado);
					RequestDispatcher rd = request.getRequestDispatcher("EventoIndex.jsp");
					rd.forward(request, response);
				case "buscarPorNombre":
					String evento = request.getParameter("txtEvento");
					resultado = buscarPorNombre(evento);
					request.setAttribute("resultado", resultado);
					RequestDispatcher rd1 = request.getRequestDispatcher("buscarEvento.jsp");
					rd1.forward(request, response);
					break;
				}
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	public Collection<Evento> listar() throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		return gestion.listar();
	}
	
	public Collection<Evento> buscarPorNombre(String evento) throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		return gestion.buscarPorNombre(evento);
	}

}
