package studio7i.dao;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Sala;

public interface SalaDAO {

	public Sala validar(String idUsuario, String clave) throws DAOExcepcion;
	
	public Sala insertar(Sala vo)  throws DAOExcepcion;
	


}

