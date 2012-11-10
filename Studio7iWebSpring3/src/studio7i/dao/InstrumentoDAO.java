package studio7i.dao;

import java.util.Collection;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;;


public interface InstrumentoDAO {
	
	public Instrumento insertar(Instrumento vo) throws DAOExcepcion;
	public Instrumento actualizar(Instrumento vo) throws DAOExcepcion;
	public void eliminar(int instrumento_id)throws DAOExcepcion;
	public Collection<Instrumento> listar() throws DAOExcepcion;
	public Instrumento obtener(int Instrumento_id) throws DAOExcepcion;
	public Collection<Instrumento>buscarPorTipo(String tipo)throws DAOExcepcion;
	
}
