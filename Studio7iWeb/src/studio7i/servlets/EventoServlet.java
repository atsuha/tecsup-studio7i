package studio7i.servlets;

import java.io.IOException;

import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.print("Evento Servlet" + request.getParameter("cmd"));
		
		HttpSession miSesion = request.getSession(true);
		String cmd = request.getParameter("cmd");
		Evento evento = new Evento();
		
		//crear evento
		if (cmd.equals("crear")){
			String nomb = request.getParameter("txtNombre");
			String desc = request.getParameter("txtDescripcion");
			String lug = request.getParameter("txtLugar");
			String fech = request.getParameter("txtFecha");
			String prem = request.getParameter("txtPremios");
			
			try {
				insertar(nomb, desc, lug, fech, prem);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("EventoIndex.jsp");
			rd.forward(request,response);
		}
		
		if (cmd.equals("buscarNombre")){
			
			String nombre = request.getParameter("txtEvento");
			GestionEvento gestion = new GestionEvento();
			String mensaje;
			Collection<Evento> resultado = null;
			
			
			try{
				if(nombre.equals(evento.getNombre()) || nombre == evento.getNombre()){
					resultado = gestion.buscarPorNombre(nombre);
				}			
			
			request.setAttribute("resultado", resultado);
			
			if (evento == null){
				mensaje = "No existe el evento de nombre " + nombre;
			}
			}catch (DAOExcepcion e){
				e.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("BuscarEvento.jsp");
			rd.forward(request, response);
		}
		
		if (cmd.equals("listar")){
			try{
				Collection<Evento> resultado = listar();
				System.out.print(resultado.size());
				
				request.setAttribute("lista", resultado);
				
	
				
			}catch (DAOExcepcion e){
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("EventoIndex.jsp");
			rd.forward(request,response);
		}
		
		/*
		if (cmd.equals("eliminar")){
			try{
				eliminar();
			}catch (DAOExcepcion e){
				e.printStackTrace();
			}
		}
		*/
		
			
		}
	
	public void insertar(String nombre, String descripcion, String lugar, String fecha, String premios)throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		gestion.insertar(nombre, descripcion, lugar, fecha, premios);
	}
	

	
	
	public Collection<Evento> listar() throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		return gestion.listar();
	}
	
	public void eliminar(int evento_id)throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		gestion.eliminar(evento_id);
	}
		

}
