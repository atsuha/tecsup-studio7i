package studio7i.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio7i.dao.EventoDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;

@Service
public class EventoServiceImpl implements EventoService{

	@Autowired
	private EventoDAO eventoDAO;
	
	public void setEventoDAO(EventoDAO eventoDAO){
		this.eventoDAO = eventoDAO;
	}
	
	public Evento insertar(Evento ev)throws DAOExcepcion{
		return eventoDAO.insertar(ev);
	}

	public Collection<Evento> buscarNombre(String nombre) throws DAOExcepcion {
		return eventoDAO.buscarNombre(nombre);
	}
	
	public Evento obtenerPorId(String evento_id)throws DAOExcepcion{
		return eventoDAO.obtenerPorId(evento_id);
	}
	
	public void eliminar(String evento_id)throws DAOExcepcion{
		eventoDAO.eliminar(evento_id);
	}
	
	public Evento actualizar(Evento ev)throws DAOExcepcion{
		return eventoDAO.actualizar(ev);
	}
	
}
