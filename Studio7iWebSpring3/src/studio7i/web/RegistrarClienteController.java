package studio7i.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Persona;
import studio7i.service.ClienteService;


@Controller
public class RegistrarClienteController {
	
	@Autowired
	private ClienteService clienteService;

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@RequestMapping(value = "/RegistrarCliente")//se consider con el mismo nombre en el er redirect.jsp y lo muestra en la url
	protected ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("inscripcionCliente");//jsp
	}
	

	
	@RequestMapping(value = "/inscripcion_cliente")
	protected ModelAndView registrar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView mv = null;
		
		//String cliente_id 		= request.getParameter("idUsuario");
		String dni 					= request.getParameter("txtdni");
		String nombres 				= request.getParameter("txtnombre");
		String paterno				= request.getParameter("txtpaterno");
		String materno 				= request.getParameter("txtmaterno");
		String correo 				= request.getParameter("txtemail");
		String fecha_nacimiento 	= 	request.getParameter("txtfecha");
		String usuario 				= request.getParameter("txtusuario");
		String password 			= request.getParameter("txtpassword");
		String validarpassword		= request.getParameter("txtvalidar");
		
		Persona cliente = new Persona();
		
		
		cliente.setDni(dni);
		cliente.setNombres(nombres);
		cliente.setPaterno(paterno);
		cliente.setMaterno(materno);
		cliente.setEmail(correo);
		cliente.setFechaNacimiento(fecha_nacimiento);
		cliente.setUsuario(usuario);
		cliente.setPassword(password);
		
		
		try {
			clienteService.insertarCliente(cliente);
			mv = new ModelAndView("inscripcionCliente");
		} catch (DAOExcepcion e) {
			
			mv  = new ModelAndView("inscripcionCliente","mensaje","No se pudo registrar");
		}	

		return mv;
	}
	
	
	
} 
