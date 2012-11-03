package studio7i.service;

import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Local;

public interface LocalService {

	public Collection<Local> buscarPorNombre(String nombre);
	
	public Local insertar(Local vo) throws DAOExcepcion;
	
	public Local obtener(int idLocal) throws DAOExcepcion;
	
	public void eliminar(int idLocal) throws DAOExcepcion;
	
	public Local actualizar(Local vo) throws DAOExcepcion;
	
	public Collection<Local> listar() throws DAOExcepcion;
}
