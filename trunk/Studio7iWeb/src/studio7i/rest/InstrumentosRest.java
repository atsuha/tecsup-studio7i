package studio7i.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.ReservaInstrumento;
import studio7i.negocio.GestionReservaInstrumento;

import net.sf.json.JSONArray;

@Path("/instrumentos")
public class InstrumentosRest {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar( @QueryParam("reserva_id") int reserva_id ) {		

		JSONArray arrayObj = new JSONArray();
		
		try {
			GestionReservaInstrumento negocio = new GestionReservaInstrumento();
			Collection<ReservaInstrumento> instrumentos =  negocio.buscarPorReservaId(reserva_id);
			System.out.println(instrumentos.size());
			arrayObj.addAll(instrumentos);
			
		} catch (DAOExcepcion e) {	
			System.out.println(e.getMessage());
		}
		return arrayObj.toString();
	}
	

}
