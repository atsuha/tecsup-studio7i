package studio7i.dao;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;

public interface EventoDAO {

	public Evento insertar(Evento ev)throws DAOExcepcion;
}
