package studio7i.service;

import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;

public interface InstrumentoService {

	public Instrumento insertar(Instrumento vo) throws DAOExcepcion; 
	public Instrumento obtener(int instrumento_id) throws DAOExcepcion;
	public void eliminar(int id) throws DAOExcepcion;
	public Instrumento actualizar(Instrumento vo) throws DAOExcepcion;
	public Collection<Instrumento> listar() throws DAOExcepcion;
	public Collection<Instrumento> buscarPorTipo(String tipo)throws DAOExcepcion;
}