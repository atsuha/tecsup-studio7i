package studio7i.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;

@Path("/instrumentos")
public class InstrumentosRest {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar( @QueryParam("nombre") String nombre ) {		

		JSONArray arrayObj = new JSONArray();
		
		try {
			GestionProductos negocio = new GestionProductos();
			Collection<Producto> productos =  negocio.buscarPorNombre(nombre);
			System.out.println(productos.size());
			arrayObj.addAll(productos);
			
		} catch (DAOExcepcion e) {	
			System.out.println(e.getMessage());
		}
		return arrayObj.toString();
	}
	

}
