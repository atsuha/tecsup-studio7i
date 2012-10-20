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
import studio7i.negocio.GestionInscrito;


@WebServlet("/InscripcionServlet")
public class InscripcionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String metodo = request.getParameter("metodo");
		String evento_id = request.getParameter("evento");
		try{
			switch(metodo){
			case "mostrar":
				Evento evento = buscar(Integer.parseInt(evento_id));
				request.setAttribute("EVENTO", evento);
				RequestDispatcher rd = request.getRequestDispatcher("inscripcionCliente.jsp");
				rd.forward(request,response);
				break;
			}
		}catch (DAOExcepcion e){
			e.printStackTrace();
		}
	}
	
	public Evento buscar(int evento_id)throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		return gestion.buscar(evento_id);
	}


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
				
		RequestDispatcher rd = request.getRequestDispatcher("InscripcionAevento.jsp");
		rd.forward(request,response);		
		}
		
		if(metodo.equals("inscribir")){
			String evento_id = request.getParameter("evento");
			String fecha = request.getParameter("txtFecha");
			String presentacion = request.getParameter("txtPresentacion");
			try{
				//falta arreglar la parte de persona_id, para que agregue debe estar persona_id en la bd
				insertar(Integer.parseInt(evento_id),1, fecha,presentacion);
			}catch (DAOExcepcion e){
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("InscripcionAevento.jsp");
			rd.forward(request, response);
			
		}
		
	}
	
	
	public Collection<Evento> buscarNombre(String evento) throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		return gestion.buscarPorNombre(evento);
	}
	
	public void insertar(int evento_id, int persona_id, String fecha, String presentacion) throws DAOExcepcion{
		GestionInscrito gestion = new GestionInscrito();
		gestion.insertar(evento_id, persona_id, fecha, presentacion);
	}

}
