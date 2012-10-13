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

import org.apache.tomcat.jni.Local;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.modelo.Sala;
import studio7i.modelo.SalaInstrumento;
import studio7i.modelo.SalaServicio;
import studio7i.modelo.Servicio;
import studio7i.negocio.GestionLocal;
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
		String metodo = request.getParameter("metodo");
		String sala_id = request.getParameter("sala");
		PrintWriter out = response.getWriter();
		GestionLocal dao = new GestionLocal();
		GestionSala daos = new GestionSala();
		RequestDispatcher rd;
		Collection<Sala> resultado = new ArrayList<Sala>();
		try {
			switch (metodo) {
				case "editar":
					Sala sala = obtener(Integer.parseInt(sala_id));
					request.setAttribute("SALA", sala);
					request.setAttribute("LOCAL", dao.listar());
					rd = request.getRequestDispatcher("editarSala.jsp");
					rd.forward(request, response);
					break;
				case "nuevo":
					request.setAttribute("LOCAL", dao.listar());
					rd = request.getRequestDispatcher("inscripcionSala.jsp");
					rd.forward(request, response);
					break;
				case "eliminar":
					daos.eliminar(Integer.parseInt(sala_id));
					/*resultado = listar();
					request.setAttribute("LISTA", resultado);
					rd = request.getRequestDispatcher("SalaIndex.jsp");
					rd.forward(request, response);*/
					break;
				case "listar":
					resultado = listar();
					request.setAttribute("LISTA", resultado);
					rd = request.getRequestDispatcher("SalaIndex.jsp");
					rd.forward(request, response);
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		PrintWriter out = response.getWriter();
		Collection<Sala> resultado = new ArrayList<Sala>();
		
		String sala_id = request.getParameter("sala_id");
		System.out.println(sala_id);
		String nombre = request.getParameter("nombre");
		String capacidad = request.getParameter("capacidad");
		String local = request.getParameter("local");
		String caracteristicas = request.getParameter("caracteristicas");
		String costo = request.getParameter("costo");
		
		Collection<SalaServicio> listaServicios = new ArrayList<SalaServicio>();
		Collection<SalaInstrumento> listaInstrumentos = new ArrayList<SalaInstrumento>();
		
		GestionSala dao = new GestionSala();
		
		RequestDispatcher rd1;
		
		try {
			switch (metodo) {
				case "listar": 
					resultado = listar();
					request.setAttribute("LISTA", resultado);
					RequestDispatcher rd = request.getRequestDispatcher("SalaIndex.jsp");
					rd.forward(request, response);
				case "buscarPorNombre":
					String sala = request.getParameter("txtSala");
					resultado = buscarPorNombre(sala);
					request.setAttribute("LISTA", resultado);
					request.setAttribute("TEXTO", sala);
					rd1 = request.getRequestDispatcher("SalaIndex.jsp");
					rd1.forward(request, response);
					break;
				case "grabar":
					dao.insertar2(nombre, Integer.parseInt(capacidad), caracteristicas, Double.parseDouble(costo), Integer.parseInt(local));
					rd1 = request.getRequestDispatcher("SalaIndex.jsp");
					rd1.forward(request, response);
					break;
				case "editar":
					dao.acutalizar(Integer.parseInt(sala_id), nombre, Integer.parseInt(capacidad), caracteristicas, Double.parseDouble(costo), Integer.parseInt(local),"1");
					resultado = listar();
					request.setAttribute("LISTA", resultado);
					rd = request.getRequestDispatcher("SalaIndex.jsp");
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

	public Collection<Sala> buscarPorNombre(String sala) throws DAOExcepcion{
		GestionSala dao = new GestionSala();
		return dao.buscarPorNombre(sala);
	}
	
	public Sala obtener(int sala_id)throws DAOExcepcion{
		GestionSala dao = new GestionSala();
		return dao.obtener(sala_id);
	}
	
}
