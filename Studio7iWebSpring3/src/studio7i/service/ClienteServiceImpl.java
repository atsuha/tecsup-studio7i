package studio7i.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio7i.dao.ClienteDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Persona;


@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;

	
	public Persona insertarCliente(Persona vo) throws DAOExcepcion{
		return clienteDAO.insertarCliente(vo);
	}
	
	/*
//	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {DAOExcepcion.class})
	public Usuario insertarUsuarioRol(Usuario vo, Rol rol) throws DAOExcepcion {
		
		Usuario u =  usuarioDAO.insertar(vo);
		
		usuarioDAO.agregarRol(vo, rol);
		
		return u;
	}*/

	
}