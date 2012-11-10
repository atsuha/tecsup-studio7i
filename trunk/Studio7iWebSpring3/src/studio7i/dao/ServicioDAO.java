package studio7i.dao;

import java.util.Collection;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Servicio;;;


public interface ServicioDAO {
	
	public Servicio insertar(Servicio vo) throws DAOExcepcion;
	public Servicio actualizar(Servicio vo) throws DAOExcepcion;
	public void eliminar(int servicio_id)throws DAOExcepcion;
	public Collection<Servicio> listar() throws DAOExcepcion;
	public Servicio obtener(int servicio_id) throws DAOExcepcion;
	public Collection<Servicio>buscarPorDescripcion(String descripcion)throws DAOExcepcion;
	
}
