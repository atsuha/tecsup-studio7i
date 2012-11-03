package studio7i.service;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Persona;


public interface ClienteService {

	public Persona insertarCliente(Persona vo) throws DAOExcepcion ;

}
