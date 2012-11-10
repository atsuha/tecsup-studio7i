package studio7i.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio7i.dao.ServicioDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Servicio;

@Service
public class ServicioServiceImpl implements ServicioService{

	@Autowired
	private ServicioDAO ServicioDAO;

	public void setInstrumentoDAO(ServicioDAO ServicioDAO) {
		this.ServicioDAO = ServicioDAO;
	}
	
	@Override
	public Servicio insertar(Servicio vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return ServicioDAO.insertar(vo);
	}

	@Override
	public Servicio obtener(int servicio_id) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return ServicioDAO.obtener(servicio_id);
	}

	@Override
	public void eliminar(int servicio_id) throws DAOExcepcion {
		// TODO Auto-generated method stub
		ServicioDAO.eliminar(servicio_id);
	}

	@Override
	public Servicio actualizar(Servicio vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return ServicioDAO.actualizar(vo);
	}

	@Override
	public Collection<Servicio> listar() throws DAOExcepcion {
		// TODO Auto-generated method stub
		return ServicioDAO.listar();
	}


	@Override
	public Collection<Servicio> buscarPorDescripcion(String descripcion) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return ServicioDAO.buscarPorDescripcion(descripcion);
	}

}
