package studio7i.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;
import studio7i.service.EventoService;

@Controller
public class EventoController {

	private EventoService eventoService;
	public void setEventoService(EventoService eventoService){
		this.eventoService = eventoService;
	}
	
	@RequestMapping(value = "/evento", method=RequestMethod.GET)
	protected ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		return new ModelAndView("EventoIndex");
	}
	
	@RequestMapping(value = "/inscripcionEvento", method=RequestMethod.GET)
	protected ModelAndView inscripcion(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		return new ModelAndView("inscripcionEvento");
	}
	
	@RequestMapping(value = "/insertarEvento")
	protected ModelAndView insertar(HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("Dentro de insertar-EventoController");
		ModelAndView mv = null;
		
		String nombreEvento = request.getParameter("txtNombre");
		String descripcion = request.getParameter("txtDescripcion");
		String lugar = request.getParameter("txtLugar");
		String fecha = request.getParameter("txtFecha");
		String premios = request.getParameter("txtPremios");
		
		Evento ev = new Evento();
		ev.setNombre(nombreEvento);
		ev.setDescripcion(descripcion);
		ev.setLugar(lugar);
		ev.setFecha(fecha);
		ev.setPremios(premios);
		
		try{
			eventoService.insertar(ev);
			mv = new ModelAndView("EventoIndex");
		}catch(DAOExcepcion e){
			mv = new ModelAndView("EventoIndex", "mensaje", "No se pudo crear el evento");
		}
		return mv;
	}
	
	
}
