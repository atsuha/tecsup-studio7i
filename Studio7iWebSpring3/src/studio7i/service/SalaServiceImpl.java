package studio7i.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio7i.dao.SalaDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Sala;

@Service
public class SalaServiceImpl implements SalaService{

	@Autowired
	private SalaDAO salaDAO;

	public void setSalaDAO(SalaDAO salaDAO) {
		this.salaDAO = salaDAO;
	}
	
	@Override
	public Sala insertar(Sala vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return salaDAO.insertar(vo);
	}

	@Override
	public Sala obener(String id) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return salaDAO.obener(id);
	}

	@Override
	public void eliminar(String id) throws DAOExcepcion {
		// TODO Auto-generated method stub
		salaDAO.eliminar(id);
	}

	@Override
	public Sala actualizar(Sala vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return salaDAO.actualizar(vo);
	}

	@Override
	public Collection<Sala> listar() throws DAOExcepcion {
		// TODO Auto-generated method stub
		return salaDAO.listar();
	}

	@Override
	public Collection<Sala> buscarPorSalaId(String id) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return salaDAO.buscarPorSalaId(id);
	}

	@Override
	public Collection<Sala> buscarPorNombre(String nombre) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return salaDAO.buscarPorNombre(nombre);
	}

}
