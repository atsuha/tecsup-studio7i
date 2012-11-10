package studio7i.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import studio7i.modelo.Local;
import studio7i.modelo.Sala;
import studio7i.service.LocalService;
import studio7i.service.SalaService;

@Controller
public class SalaController {

	@Autowired
	private SalaService salaService;
	private LocalService localService;
	
	public void setLocalService(LocalService localService) {
		this.localService = localService;
	}

	public void setSalaService(SalaService salaService) {
		this.salaService = salaService;
	}
	
	@RequestMapping(value = "/ver_salas")
	protected ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Collection<Sala> listaSala = salaService.listar();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("LISTA", listaSala);
		return new ModelAndView("SalaIndex","map",map);
	}
	
	@RequestMapping(value = "/nueva_sala")
	protected ModelAndView nueva(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
//			System.out.println("controller");
//			Collection<Local> listaLocal = localService.listar();
//			Map<Object, Object> map = new HashMap<>();
//			map.put("LOCAL", listaLocal);
//			return new ModelAndView("inscripcionSala","map",map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("inscripcionSala");
	}
	
	@RequestMapping(value = "/grabar_sala")
	protected ModelAndView grabar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView mv = null;
		Collection<Sala> listaSala = salaService.listar();
		
		String nombre = request.getParameter("nombre");
		String local = request.getParameter("local");
		String capacidad = request.getParameter("capacidad");
		String caracteristicas = request.getParameter("caracteristicas");
		String costo = request.getParameter("costo");
		
		Local objLocal = new Local();
		objLocal.setLocal_id(1);
		
		Sala vo = new Sala();
		vo.setNombre(nombre);
		vo.setLocal(objLocal);
		vo.setCapacidad(Integer.parseInt(capacidad));
		vo.setCaracteristicas(caracteristicas);
		vo.setCosto(Double.parseDouble(costo));
		
		try {
			salaService.insertar(vo);
			String msg = "SE REGISTRO CORRECTAMENTE";
			Map<Object, Object> map = new HashMap<>();
			map.put("LISTA", listaSala);
			map.put("RESULTADO", msg);
			System.out.println(listaSala.size());
			System.out.println(msg);
			mv = new ModelAndView("SalaIndex","map",map);
//			this.inicio(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String msg = "OCURRIO UN ERROR";
			mv = new ModelAndView("SalaIndex","LISTA",listaSala);
//			this.inicio(request, response);
		}		
		
		return mv;
	}
	
	@RequestMapping(value = "/editar_sala")
	protected ModelAndView editar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("inscripcionSala");
	}
	
}
