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
import javax.servlet.http.HttpSession;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;
import studio7i.modelo.Sala;
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

		String metodo = request.getParameter("metodo");
		PrintWriter out = response.getWriter();
		String evento_id = request.getParameter("evento");
		RequestDispatcher rd;
		try{
			switch(metodo){
			case "editar":		
				Evento evento1 = buscar(Integer.parseInt(evento_id));
				request.setAttribute("EVENTO", evento1);
				rd =  request.getRequestDispatcher("editarEvento.jsp");
				rd.forward(request, response);
				break;
		
			case "eliminar":
				eliminar(Integer.parseInt(evento_id));
				rd =  request.getRequestDispatcher("EventoIndex.jsp");
				rd.forward(request, response);
			}

		}catch (DAOExcepcion e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	}
	
	public Evento buscar(int evento_id)throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		return gestion.buscar(evento_id);
	}
	
	public void eliminar(int evento_id)throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		gestion.eliminar(evento_id);
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.print("Evento Servlet" + request.getParameter("metodo"));
		String metodo = request.getParameter("metodo");
		
		
		//crear evento
		if (metodo.equals("crear")){
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
		
		
		
		
		
		
		if (metodo.equals("buscarNombre")){
			
			Collection<Evento> resultado = new ArrayList<Evento>();
			String nombre = request.getParameter("txtEvento");
			
			try {
				resultado = buscarNombre(nombre);
				System.out.print(nombre);
				request.setAttribute("resultado", resultado);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("BuscarEvento.jsp");
			rd.forward(request, response);
		}
				
		
		
		
		if (metodo.equals("listar")){
			try{
				Collection<Evento> resultado = listar();
				System.out.print(resultado.size());				
				request.setAttribute("lista", resultado);				
			}catch (DAOExcepcion e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("EventoIndex.jsp");
			rd.forward(request,response);
		}
		
		
		if (metodo.equals("grabar")){
		
			PrintWriter out = response.getWriter();
			String evento_id = request.getParameter("evento");
			System.out.print(evento_id);

			String nomb = request.getParameter("txtNombre");
			String desc = request.getParameter("txtDescripcion");
			String lug = request.getParameter("txtLugar");
			String fech = request.getParameter("txtFecha");
			String prem = request.getParameter("txtPremios");
		try{
			actualizar(Integer.parseInt(evento_id),nomb, desc, lug, fech, prem);
				}catch (DAOExcepcion e){
					e.printStackTrace();
				}
		RequestDispatcher rd = request.getRequestDispatcher("EventoIndex.jsp");
		rd.forward(request,response);
		
		}

		
		
	
		}
	
	public void insertar(String nombre, String descripcion, String lugar, String fecha, String premios)throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		gestion.insertar(nombre, descripcion, lugar, fecha, premios);
	}
	
	public Collection<Evento> buscarNombre(String evento) throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		return gestion.buscarPorNombre(evento);
	}
	
	
	public Collection<Evento> listar() throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		return gestion.listar();
	}
	
	public Evento actualizar(int evento_id,String nombre, String descripcion, String lugar, String fecha, String premios)throws DAOExcepcion{
		GestionEvento gestion = new GestionEvento();
		return gestion.actualizar(evento_id, nombre, descripcion, lugar, fecha, premios);
		
	}
	
	

	

}
