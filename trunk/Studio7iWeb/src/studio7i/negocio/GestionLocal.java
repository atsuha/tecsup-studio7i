package studio7i.negocio;

import java.util.Collection;

import studio7i.dao.LocalDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Local;

public class GestionLocal {
	
	public Collection<Local> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();
		return dao.listar();
	}

	public Local insertar(String nombre, String direccion)
			throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();

		Local vo = new Local();
		vo.setNombre(nombre);
		vo.setDireccion(direccion);

		return dao.insertar(vo);
	}
	
	public Local obtener(int idLocal) throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();
		return dao.obtener(idLocal);
	}
	
	public void eliminar(int idLocal) throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();
		dao.eliminar( idLocal);
	}
	
	public Local actualizar(int idLocal, String nombre,
			String direccion) throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();

		Local vo = new Local();
		vo.setLocal_id(idLocal);
		vo.setNombre(nombre);
		vo.setDireccion(direccion);

		return dao.actualizar(vo);
	}
	
	public Collection<Local> listar() throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();
		return dao.listar();
	}

}
