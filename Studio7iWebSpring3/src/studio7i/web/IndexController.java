package studio7i.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)	
	protected ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("verLocales");
	}

}

