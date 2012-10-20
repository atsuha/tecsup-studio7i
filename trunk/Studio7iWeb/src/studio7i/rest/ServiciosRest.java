package studio7i.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Servicio;
import studio7i.negocio.GestionServicios;

import net.sf.json.JSONArray;

@Path("/servicios")
public class ServiciosRest {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar( @QueryParam("nombre") String nombre ) {		

		JSONArray arrayObj = new JSONArray();
		
		try {
			GestionServicios negocio = new GestionServicios();
			Collection<Servicio> servicios =  negocio.listar();
			System.out.println(servicios.size());
			for(Servicio serv : servicios){
				Servicio obj = new Servicio();
				obj.setServicio_id(serv.getServicio_id());
				obj.setDescripcion(serv.getDescripcion());
				obj.setEstado(serv.getEstado());
				obj.setPrecio_hora(serv.getPrecio_hora());
				arrayObj.add(obj);
			}
			//arrayObj.addAll(servicios);			
		} catch (DAOExcepcion e) {	
			System.out.println(e.getMessage());
		}
		return arrayObj.toString();
	}
	
}
