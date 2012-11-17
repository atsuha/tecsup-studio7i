package studio7i.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Local;
import studio7i.modelo.Servicio;
import studio7i.service.LocalService;
import studio7i.service.ServicioService;

@Controller
public class ServicioController {

	@Autowired
	private ServicioService servicioService;
	
	public void setServicioService(ServicioService servicioService) {
		this.servicioService = servicioService;
	}
	
	@Autowired
	private LocalService localService;
	
	public void setLocalService(LocalService localService) {
		this.localService = localService;
	}
	
	
	@RequestMapping(value = "/ver_servicios")
	protected ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Collection<Servicio> listaServicio = servicioService.listar();
		return new ModelAndView("servicioIndex","LISTA",listaServicio);
	}
	
	@RequestMapping(value = "/buscar_reg")
	protected ModelAndView buscar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String buscar=request.getParameter("buscar");
		
		Collection<Servicio> listaServicio = servicioService.buscarPorDescripcion(buscar);
		return new ModelAndView("servicioIndex","LISTA",listaServicio);
	}
	
	@RequestMapping(value = "/reg_servicios", method=RequestMethod.POST)
	protected ModelAndView registrar(HttpServletRequest request,
				HttpServletResponse response)throws Exception{
		
				
				String servicio_id=request.getParameter("txtServicio");
				String descripcion = request.getParameter("txtDescripcion");
				String local_id = request.getParameter("cboLocal");
				String precio_hora = request.getParameter("txtPrecioHora");
				
				String mensaje;	
				Servicio vo =new Servicio();
				vo.setDescripcion(descripcion);
				vo.setServicio_id(Integer.parseInt(servicio_id));
				Local lo =new Local();
				lo.setLocal_id(Integer.parseInt(local_id));
				vo.setLocal(lo);
				vo.setPrecio_hora(Double.parseDouble(precio_hora));

				Map<Object, Object> map = new HashMap<>();
	
				try {
					System.out.println(servicio_id + "," + descripcion + "," + local_id + "," + precio_hora);
					servicioService.actualizar(vo);
					System.out.println("Paso Actualizar");
					mensaje="Se actualizó correctamente";
					Collection<Servicio> listaServicio = servicioService.listar();
					request.setAttribute("MENSAJE",
							"Se actualizó correctamente");
					request.setAttribute("LISTA",
							listaServicio);
					
				
				} catch (DAOExcepcion e) {
					
					mensaje="Se actualizó correctamente";
				}
			
			
							
		return new ModelAndView("servicioIndex");
	}
	
	
	@RequestMapping(value = "/nuevo_registro", method=RequestMethod.POST)
	protected ModelAndView nuevo_reg(HttpServletRequest request,
				HttpServletResponse response)throws Exception{
		
				

				String descripcion = request.getParameter("txtDescripcion");
				String local_id = request.getParameter("cboLocal");
				String precio_hora = request.getParameter("txtPrecioHora");
				
				String mensaje;	
				Servicio vo =new Servicio();
				vo.setDescripcion(descripcion);
				Local lo =new Local();
				lo.setLocal_id(Integer.parseInt(local_id));
				vo.setLocal(lo);
				vo.setPrecio_hora(Double.parseDouble(precio_hora));

				Map<Object, Object> map = new HashMap<>();
	
				try {
					System.out.println( descripcion + "," + local_id + "," + precio_hora);
					
					servicioService.insertar(vo);
					System.out.println("Paso Insertar");
					mensaje="Se registró correctamente";
					Collection<Servicio> listaServicio = servicioService.listar();
					request.setAttribute("MENSAJE",
							"Se registró correctamente");
					request.setAttribute("LISTA",
							listaServicio);
					
				
				} catch (DAOExcepcion e) {
					
					mensaje="No se registró correctamente";
				}
			
			
							
		return new ModelAndView("servicioIndex");
	}
	@RequestMapping(value = "/editar_servicio", method=RequestMethod.GET)
	protected ModelAndView edicion(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		
				String metodo = request.getParameter("metodo");
	
				String servicio_id = request.getParameter("servicio");
				
				System.out.println(servicio_id + "," + metodo);
						
				
				Servicio servicio = servicioService.obtener(Integer.parseInt(servicio_id));
				Collection<Local> listaLocal = localService.listar();
				
				Map<Object, Object> map = new HashMap<>();
				map.put("SERVICIO", servicio);
				map.put("LOCAL", listaLocal);
						
		return new ModelAndView("editarServicio","map",map);
	}
	
	
	@RequestMapping(value = "/nuevo_servicio", method=RequestMethod.GET)
	protected ModelAndView nuevo(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		
			
				
			
						
				
			
				Collection<Local> listaLocal = localService.listar();
				
				Map<Object, Object> map = new HashMap<>();
		
				map.put("LOCAL", listaLocal);
						
		return new ModelAndView("inscripcionServicio","map",map);
	}
}
