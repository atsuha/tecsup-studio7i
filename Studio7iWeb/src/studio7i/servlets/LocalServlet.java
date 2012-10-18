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
		Local local = null;
		String idLocal = request.getParameter("idLocal");
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		try {
			switch (metodo) {
				case "listar": 
					locales = listar();
					request.setAttribute("RESULTADO", locales);
					RequestDispatcher rd = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd.forward(request, response);
					break;	
				case "obtener":
					local = obtener(Integer.parseInt(idLocal));
					request.setAttribute("RESULTADO", local);
					RequestDispatcher rd1 = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd1.forward(request, response);
					break;						
				case "insertar": 
					local = insertar(nombre, direccion);
					request.setAttribute("RESULTADO", local);
					RequestDispatcher rd2 = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd2.forward(request, response);
					break;
				case "eliminar": 
					eliminar(Integer.parseInt(idLocal));
					RequestDispatcher rd3 = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd3.forward(request, response);
					break;					
				case "buscarPorNombre": 
					locales = buscarPorNombre(nombre);
					request.setAttribute("RESULTADO", locales);
					RequestDispatcher rd4 = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd4.forward(request, response);
					break;
				case "actualizar": 
					local = actualizar(Integer.parseInt(idLocal), nombre, direccion);
					request.setAttribute("RESULTADO", local);
					RequestDispatcher rd5 = request.getRequestDispatcher(""); // *** modificar jsp quien lo necesite. *** //
					rd5.forward(request, response);
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
	
	public Local obtener(int idLocal)  throws DAOExcepcion{
		GestionLocal dao = new GestionLocal();
		return dao.obtener(idLocal);
	}

	public Local insertar(String nombre, String direccion)  throws DAOExcepcion{
		GestionLocal dao = new GestionLocal();
		return dao.insertar(nombre, direccion);
	}
	
	public void eliminar(int idLocal)  throws DAOExcepcion{
		GestionLocal dao = new GestionLocal();
		dao.eliminar(idLocal);
	}	
	
	public Collection<Local> buscarPorNombre(String nombre) throws DAOExcepcion{
		GestionLocal dao = new GestionLocal();
		return dao.buscarPorNombre(nombre);
	}
	
	public Local actualizar(int idLocal, String nombre, String direccion)  throws DAOExcepcion{
		GestionLocal dao = new GestionLocal();
		return dao.actualizar(idLocal, nombre, direccion);
	}	

}
