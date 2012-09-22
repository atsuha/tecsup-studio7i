package studio7i.negocio;

import java.util.Collection;

import studio7i.dao.LocalDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Local;;


public class GestionLocal {
	
	public Local obtener(int idLocal) throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();
		return dao.obtener(idLocal);
	}
	
	public Collection<Local> listar() throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();
		return dao.listar();
	}

}
