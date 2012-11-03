package studio7i.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio7i.dao.LocalDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Local;

@Service
public class LocalServiceImpl implements LocalService {

	@Autowired
	private LocalDAO localDAO;

	public void setUsuarioDAO(LocalDAO localDAO) {
		this.localDAO = localDAO;
	}
	
	@Override
	public Collection<Local> buscarPorNombre(String nombre) {
		return localDAO.buscarPorNombre(nombre);
	}

	@Override
	public Local insertar(Local vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Local obtener(int idLocal) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int idLocal) throws DAOExcepcion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Local actualizar(Local vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Local> listar() throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

}
