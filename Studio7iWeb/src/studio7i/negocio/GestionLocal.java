package studio7i.negocio;

import studio7i.dao.LocalDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Local;;

public class GestionLocal {
	
	public Local obtener(int idLocal) throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();
		return dao.obtener(idLocal);
	}

}
