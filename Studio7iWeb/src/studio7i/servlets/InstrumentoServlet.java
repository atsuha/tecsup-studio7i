package studio7i.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studio7i.modelo.Instrumento;
import studio7i.negocio.GestionInstrumentos;
import studio7i.negocio.GestionLocal;

/**
 * Servlet implementation class InstrumentoServlet
 */
@WebServlet("/InstrumentoServlet")
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
		String metodo = request.getParameter("metodo");
		System.out.println(metodo);
		GestionLocal dao = new GestionLocal();
		GestionInstrumentos negocio = new GestionInstrumentos();

		RequestDispatcher rd;
		try {
			switch (metodo) {
			case "editar":
				String instrumento_id = request.getParameter("instrumento");
				System.out.println(instrumento_id);
				Instrumento instrumento = negocio.obtener(Integer
						.parseInt(instrumento_id));

				request.setAttribute("INSTRUMENTO", instrumento);
				request.setAttribute("LOCAL", dao.listar());
				rd = request.getRequestDispatcher("editarInstrumento.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
//		System.out.println(metodo);	
		String instrumento_id = request.getParameter("txtInstrumento");
		String tipo = request.getParameter("txtTipo");		
		String caracteristicas = request.getParameter("txtCaracteristicas");
		String marca = request.getParameter("txtMarca");	
		String modelo = request.getParameter("txtModelo");	
		String local_id = request.getParameter("cboLocal");
		String precio = request.getParameter("txtPrecio");
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
			request.setAttribute("LISTA", negocio.buscarPorTipo(buscar));
		
				rd.forward(request, response);
				break;
			case "editar":								
			System.out.println(instrumento_id + "" + tipo  + "" + caracteristicas  + "" + marca  + "" + modelo  +" "+ local_id +" "+precio);
				
			negocio.actualizar(Integer.parseInt(instrumento_id), tipo,modelo,marca,caracteristicas,   Double.parseDouble(precio),Integer.parseInt( local_id));				
				break; 
			case "nuevo":									
				System.out.println(instrumento_id + "" + tipo  + "" + caracteristicas  + "" + marca  + "" + modelo  +" "+ local_id +" "+precio);
				
				negocio.insertar(tipo,marca,modelo,caracteristicas, Double.parseDouble(precio),Integer.parseInt( local_id));											
				break;
						
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
