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

import studio7i.dao.InstrumentoDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.negocio.GestionLocal;
import studio7i.negocio.GestionInstrumentos;

/**
 * Servlet implementation class ServicioServlet
 */
@WebServlet("/ServicioServlet")
public class InstrumentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InstrumentoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String metodo = request.getParameter("metodo");				
				GestionLocal dao = new GestionLocal();
				GestionInstrumentos negocio=new GestionInstrumentos();
				
				RequestDispatcher rd;
				try {
					switch (metodo) {
						case "editar":
							String instrumento_id = request.getParameter("instrumento");
							Instrumento instrumento=negocio.obtener(Integer.parseInt(instrumento_id));
							
							request.setAttribute("INSTRUMENTO", instrumento);
							request.setAttribute("LOCAL", dao.listar());
							rd = request.getRequestDispatcher("editarInstrumwnto.jsp");
							rd.forward(request, response);
							break;
						case "nuevo":
							request.setAttribute("LOCAL", dao.listar());
							rd = request.getRequestDispatcher("inscripcionInstrumento.jsp");
							rd.forward(request, response);
							break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		
		
		String servicio_id = request.getParameter("txtInstrumento");
		String descripcion = request.getParameter("txtDescripcion");		
		String local_id = request.getParameter("cboLocal");
		String precio_hora = request.getParameter("txtPrecioHora");
		GestionInstrumentos negocio=new GestionInstrumentos();
		
		
		
		RequestDispatcher rd = request
				.getRequestDispatcher("instrumentoIndex.jsp");
		
		try {
			switch (metodo) {
			case "listar":
												
			
				request.setAttribute("LISTA",
						negocio.listar());
				
				rd.forward(request, response);
				break;			
			case "filtrar":
				String buscar = request.getParameter("buscar");								
				
//				request.setAttribute("LISTA",
//						negocio.buscarPorDescripcion(buscar));
				
				rd.forward(request, response);
				break;
			case "editar":								
				System.out.println(servicio_id + "" + descripcion+" "+local_id+" "+precio_hora);
				
//				negocio.actualizar(Integer.parseInt(servicio_id), descripcion, Double.parseDouble(precio_hora),Integer.parseInt( local_id));				
				break;
			case "nuevo":									
				System.out.println(servicio_id + "" + descripcion+" "+local_id+" "+precio_hora);
//				negocio.insertar(descripcion,Double.parseDouble(precio_hora), Integer.parseInt(local_id));								
				break;
						
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
