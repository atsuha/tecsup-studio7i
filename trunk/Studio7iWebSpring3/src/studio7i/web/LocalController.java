package studio7i.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Local;
import studio7i.service.LocalService;

@Controller
public class LocalController {

	@Autowired
	private LocalService localService;

	public void setLocalService(LocalService localService) {
		this.localService = localService;
	}
	
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
			mv = new ModelAndView("redirect:ver_locales.html", "RESULTADO", locales);// con el redirect se crea un nuevo request, la variable no se carga en memoria, por eso es neceario utilizar param.MENSAJE en el jsp.
		} catch (DAOExcepcion e) {
			mv = new ModelAndView("error", "mensaje", "Usuario y/o clave incorrectos");
		}
		
		return new ModelAndView("verLocales");
	}
}
