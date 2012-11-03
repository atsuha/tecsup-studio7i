package studio7i.dao;

import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Sala;

public interface SalaDAO {
	
	public Sala insertar(Sala vo)  throws DAOExcepcion;
	public Sala obener(String id) throws DAOExcepcion;
	public void eliminar(String id) throws DAOExcepcion;
	public Sala actualizar(Sala vo) throws DAOExcepcion;
	public Collection<Sala> listar() throws DAOExcepcion;
	public Collection<Sala> buscarPorSalaId(String id) throws DAOExcepcion;
	
}

