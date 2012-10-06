package studio7i.negocio;

import java.util.Collection;
import java.util.Date;

import studio7i.dao.PersonaDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Persona;

public class GestionPersona {
	
	public Collection<Persona> buscarPorDNI(String dni)
			throws DAOExcepcion {
		PersonaDAO dao = new PersonaDAO();
		return dao.listar();
	}

	public Persona insertar(String dni, String nombres, String paterno, String materno, String email, Date fecha_nacimiento, String usuario, String password, String rol)
			throws DAOExcepcion {
		PersonaDAO dao = new PersonaDAO();

		Persona vo = new Persona();
		vo.setDni(dni);
		vo.setNombres(nombres);
		vo.setPaterno(paterno);
		vo.setMaterno(materno);
		vo.setEmail(email);
		vo.setFechaNacimiento(fecha_nacimiento);
		vo.setUsuario(usuario);
		vo.setPassword(password);
		vo.setRol(rol);

		return dao.insertar(vo);
	}
	
	public Persona obtener(int idPersona) throws DAOExcepcion {
		PersonaDAO dao = new PersonaDAO();
		return dao.obtener(idPersona);
	}
	
	public void eliminar(int idPersona) throws DAOExcepcion {
		PersonaDAO dao = new PersonaDAO();
		dao.eliminar( idPersona);
	}
	
	public Persona actualizar(int idPersona, String dni, String nombres, String paterno, String materno, String email, Date fecha_nacimiento, String usuario, String password, 
			String rol) throws DAOExcepcion {
		PersonaDAO dao = new PersonaDAO();

		Persona vo = new Persona();
		vo.setPersona_id(idPersona);
		vo.setDni(dni);
		vo.setNombres(nombres);
		vo.setPaterno(paterno);
		vo.setMaterno(materno);
		vo.setEmail(email);
		vo.setFechaNacimiento(fecha_nacimiento);
		vo.setUsuario(usuario);
		vo.setPassword(password);
		vo.setRol(rol);

		return dao.actualizar(vo);
	}
	
	public Collection<Persona> listar() throws DAOExcepcion {
		PersonaDAO dao = new PersonaDAO();
		return dao.listar();
	}

}
