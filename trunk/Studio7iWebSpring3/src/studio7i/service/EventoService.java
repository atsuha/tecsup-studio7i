package studio7i.service;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;

public interface EventoService {

	public Evento insertar(Evento ev)throws DAOExcepcion;
}
