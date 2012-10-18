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
import studio7i.modelo.Evento;
import studio7i.negocio.GestionEvento;


@WebServlet("/InscripcionServlet")
public class InscripcionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		
		if(metodo.equals("buscarNombre")){
			Collection<Evento> resultado = new ArrayList<Evento>();
			String nombre = request.getParameter("txtEvento");
			
			try{
				resultado = buscarNombre(nombre);
				request.setAttribute("resultado", resultado);
			}catch (DAOExcepcion e){
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("InscripcionIndex.jsp");
		rd.forward(request,response);		
	}
	
	
	public Collection<Evento> buscarNombre(String evento) throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		return gestion.buscarPorNombre(evento);
	}

}
