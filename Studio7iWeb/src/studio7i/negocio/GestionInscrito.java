package studio7i.negocio;

import studio7i.dao.InscritoDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;
import studio7i.modelo.Inscrito;
import studio7i.modelo.Persona;

public class GestionInscrito {

	public Inscrito insertar(String fecha, String presentacion, String usuario, int evento_id)
	throws DAOExcepcion {
		Evento ev = new Evento();
		ev.setEvento_id(evento_id);
		
		Persona pe = new Persona();
		pe.setUsuario(usuario);
		
		InscritoDAO dao = new InscritoDAO();
		
		Inscrito in = new Inscrito();
		
		in.setFecha(fecha);
		in.setPresentacion(presentacion);
		in.setEvento(ev);
		in.setPersona(pe);
		
		return dao.insertar(in);
		
		
	}
}
