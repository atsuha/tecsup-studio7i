package studio7i.dao;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Persona;


public interface ClienteDAO {
	
	public Persona insertarCliente(Persona vo) throws DAOExcepcion;
	
}
