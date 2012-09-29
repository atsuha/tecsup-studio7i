package studio7i.negocio;

import studio7i.dao.InscritoDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;
import studio7i.modelo.Inscrito;
import studio7i.modelo.Persona;

public class GestionInscrito {

	public Inscrito insertar(int evento_id, int persona_id, String fecha, String presentacion) throws DAOExcepcion {

		Evento ev = new Evento();
		ev.setEvento_id(evento_id);
		
		Persona per = new Persona();
		per.setPersona_id(persona_id);
		
		InscritoDAO dao = new InscritoDAO();
		
		Inscrito in = new Inscrito();
		
		in.setEvento(ev);
		in.setPersona(per);
		in.setFecha(fecha);
		in.setPresentacion(presentacion);
		
		
		return dao.insertar(in);		
	}
	
	
	public void eliminar(int evento_id, int persona_id)throws DAOExcepcion{
		InscritoDAO dao = new InscritoDAO();
		dao.eliminar(evento_id, persona_id);
	}
	
}
