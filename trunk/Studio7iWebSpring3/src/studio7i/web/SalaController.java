package studio7i.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import studio7i.modelo.Sala;
import studio7i.service.SalaService;

@Controller
public class SalaController {

	@Autowired
	private SalaService salaService;
	
	public void setSalaService(SalaService salaService) {
		this.salaService = salaService;
	}
	
	@RequestMapping(value = "/ver_salas")
	protected ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Collection<Sala> listaSala = salaService.listar();
		return new ModelAndView("SalaIndex","LISTA",listaSala);
//		return new ModelAndView("inscripcionSala");
	}
	
}
