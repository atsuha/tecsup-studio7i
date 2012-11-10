package studio7i.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio7i.dao.InstrumentoDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;

@Service
public class InstrumentoServiceImpl implements InstrumentoService{

	@Autowired
	private InstrumentoDAO InstrumentoDAO;

	public void setInstrumentoDAO(InstrumentoDAO InstrumentoDAO) {
		this.InstrumentoDAO = InstrumentoDAO;
	}
	
	@Override
	public Instrumento insertar(Instrumento vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return InstrumentoDAO.insertar(vo);
	}

	@Override
	public Instrumento obtener(int instrumento_id) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return InstrumentoDAO.obtener(instrumento_id);
	}

	@Override
	public void eliminar(int instrumento_id) throws DAOExcepcion {
		// TODO Auto-generated method stub
		InstrumentoDAO.eliminar(instrumento_id);
	}

	@Override
	public Instrumento actualizar(Instrumento vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return InstrumentoDAO.actualizar(vo);
	}

	@Override
	public Collection<Instrumento> listar() throws DAOExcepcion {
		// TODO Auto-generated method stub
		return InstrumentoDAO.listar();
	}


	@Override
	public Collection<Instrumento> buscarPorTipo(String tipo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return InstrumentoDAO.buscarPorTipo(tipo);
	}

}
