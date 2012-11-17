package studio7i.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.modelo.Local;
import studio7i.modelo.Servicio;
import studio7i.service.InstrumentoService;
import studio7i.service.LocalService;
import studio7i.service.ServicioService;

@Controller
public class LocalController {

	@Autowired
	private LocalService localService;

	public void setLocalService(LocalService localService) {
		this.localService = localService;
	}
	
	@Autowired
	private InstrumentoService instrumentoService;

	public void setInstrumentoService(InstrumentoService instrumentoService) {
		this.instrumentoService = instrumentoService;
	}

	
/*	@Autowired
	private ServicioService servicioService;

	public void setServicioService(ServicioService servicioService) {
		this.servicioService = servicioService;
	}*/
	
	@RequestMapping(value = "/ver_locales")
	protected ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("verLocales");
	}
	
	@RequestMapping(value = "/buscarPorNombre")
	protected ModelAndView buscarPorNombre(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("Dentro de LocalController");
		ModelAndView mv = null;
		
		String nombre = request.getParameter("nombre");
		
		try {
			Collection<Local> locales =  localService.buscarPorNombre(nombre);
			System.out.println("Locales: " + locales.size());
			Collection<Instrumento> instrumentos =  instrumentoService.listar();
			System.out.println("Instrumentos: " + instrumentos.size());
			//Collection<Servicio> servicios =  servicioService.listar();
			//System.out.println("Servicios: " + servicioService.size());
			
			String ins = "";
			for (Instrumento i: instrumentos) {
				ins = ins.concat(" "+i.getTipo());
			}
			
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("locales", locales);
			map.put("instrumentos", ins);
			
					
			
			mv = new ModelAndView("verLocales", "RESULTADO", map);// con el redirect se crea un nuevo request, la variable no se carga en memoria, por eso es neceario utilizar param.MENSAJE en el jsp.
		} catch (DAOExcepcion e) {
			mv = new ModelAndView("error", "mensaje", "Usuario y/o clave incorrectos");
		}
		
		return mv;
	}
}
