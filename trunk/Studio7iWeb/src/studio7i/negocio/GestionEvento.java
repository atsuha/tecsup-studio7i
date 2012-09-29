package studio7i.negocio;

import java.util.Collection;

import studio7i.dao.EventoDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;

public class GestionEvento {

	
	public Evento insertar(String nombre, String descripcion, String lugar, String fecha, String premios)throws DAOExcepcion{
		EventoDAO dao = new EventoDAO();
		
		Evento ev = new Evento();
		ev.setNombre(nombre);
		ev.setDescripcion(descripcion);
		ev.setLugar(lugar);
		ev.setFecha(fecha);
		ev.setPremios(premios);
		
		return dao.insertar(ev);
	}
	
	
	
	public void eliminar(int evento_id)throws DAOExcepcion{
		EventoDAO dao = new EventoDAO();
		
		dao.eliminar(evento_id);
	}
	
	
	
	public Evento buscar(int evento_id)throws DAOExcepcion{
		EventoDAO dao = new EventoDAO();
		
		return dao.buscar(evento_id);
	}
	
	
	
	public Evento actualizar(int evento_id, String nombre, String descripcion, String lugar, String fecha, String premios) throws DAOExcepcion{
		EventoDAO dao = new EventoDAO();
		Evento ev = new Evento();
		
		ev.setEvento_id(evento_id);
		ev.setNombre(nombre);
		ev.setDescripcion(descripcion);
		ev.setLugar(lugar);
		ev.setFecha(fecha);
		ev.setPremios(premios);
		
		return dao.actualizar(ev);
	}
	
	
	
	public Collection<Evento> listar() throws DAOExcepcion{
		EventoDAO dao = new EventoDAO();
		return dao.listar();
	}
	
	
	public Collection<Evento> buscarPorNombre(String nombre) throws DAOExcepcion{
		EventoDAO dao = new EventoDAO();
		return dao.buscarPorNombre(nombre);
		
	}
}

