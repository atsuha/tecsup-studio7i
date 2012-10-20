package studio7i.negocio;

import java.util.Collection;

import studio7i.dao.InstrumentoDAO;
import studio7i.dao.ServicioDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.modelo.Local;
import studio7i.modelo.Servicio;

public class GestionServicios {

	public Servicio insertar(String descripcion, double precio_hora, int local_id) throws DAOExcepcion {
		Local lo=new Local();
		lo.setLocal_id(local_id);
		
		ServicioDAO dao=new ServicioDAO();
		
		Servicio vo=new Servicio();
		vo.setDescripcion(descripcion);
		vo.setPrecio_hora(precio_hora);
		vo.setLocal(lo);
		
		return dao.insertar(vo);	
	}

	public Servicio obtener(int servicio_id) throws DAOExcepcion {
		ServicioDAO dao = new ServicioDAO();
		return dao.obtener(servicio_id);
	}

	public Servicio actualizar(int servicio_id, String descripcion, double precio_hora, int local_id)throws DAOExcepcion {
		
		Local lo=new Local();
		lo.setLocal_id(local_id);
		
		ServicioDAO dao=new ServicioDAO();
		
		Servicio vo=new Servicio();
		
		vo.setServicio_id(servicio_id);
		vo.setDescripcion(descripcion);
		vo.setPrecio_hora(precio_hora);
		vo.setLocal(lo);
		return dao.actualizar(vo);	

	}

	public Collection<Servicio> listar() throws DAOExcepcion {
		ServicioDAO dao =new ServicioDAO();
		return dao.listar();
	}

	public void eliminar(int servicio_id) throws DAOExcepcion {
		ServicioDAO dao = new ServicioDAO();
		dao.eliminar(servicio_id);
	}

	
	public Collection<Servicio> buscarPorDescripcion(String descripcion)
			throws DAOExcepcion {
		ServicioDAO dao = new ServicioDAO();
		return dao.buscarPorDescripcion(descripcion);
	}
	
	
	

}
