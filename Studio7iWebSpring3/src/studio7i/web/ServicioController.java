package studio7i.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import studio7i.modelo.Servicio;
import studio7i.service.ServicioService;

@Controller
public class ServicioController {

	@Autowired
	private ServicioService servicioService;
	
	public void setServicioService(ServicioService servicioService) {
		this.servicioService = servicioService;
	}
	
	@RequestMapping(value = "/ver_servicios")
	protected ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Collection<Servicio> listaServicio = servicioService.listar();
		return new ModelAndView("ServicioIndex","LISTA",listaServicio);
//		return new ModelAndView("inscripcionSala");
	}
	
}
