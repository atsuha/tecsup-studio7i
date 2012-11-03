package studio7i.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import studio7i.service.LocalService;

@Controller
public class LocalController {

	@Autowired
	private LocalService localService;

	public void setLocalService(LocalService localService) {
		this.localService = localService;
	}
	
	@RequestMapping(value = "/usuarios_mantener")
	protected ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("registrarUsuario");
	}
}
