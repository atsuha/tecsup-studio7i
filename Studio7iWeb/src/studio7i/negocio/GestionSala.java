package studio7i.negocio;

import java.util.Collection;

import studio7i.dao.LocalDAO;
import studio7i.dao.SalaDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Sala;
import studio7i.modelo.SalaInstrumento;
import studio7i.modelo.SalaServicio;

public class GestionSala {

	public Sala insertar(String nombre, int capacidad, String caracteristicas,
			double costo, int local, Collection<SalaServicio> listaServicios,
			Collection<SalaInstrumento> listaInstrumentos) throws DAOExcepcion {

		SalaDAO dao = new SalaDAO();

		Sala vo = new Sala();
		vo.setNombre(nombre);
		vo.setCapacidad(capacidad);
		vo.setCaracteristicas(caracteristicas);
		vo.setCosto(costo);

		LocalDAO daol = new LocalDAO();

		vo.setLocal(daol.obtener(local));

		vo.setListaServicios(listaServicios);
		vo.setListaInstrumentos(listaInstrumentos);
		try {
			return dao.insertar(vo);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Sala insertar2(String nombre, int capacidad, String caracteristicas,
			double costo, int local) throws DAOExcepcion {

		SalaDAO dao = new SalaDAO();

		Sala vo = new Sala();
		vo.setNombre(nombre);
		vo.setCapacidad(capacidad);
		vo.setCaracteristicas(caracteristicas);
		vo.setCosto(costo);

		LocalDAO daol = new LocalDAO();

		vo.setLocal(daol.obtener(local));
		try {
			return dao.insertar(vo);
		} catch (Exception e) {
			throw e;
		}
	}

	public Sala obtener(int sala_id) throws DAOExcepcion {
		SalaDAO dao = new SalaDAO();
		return dao.obtener(sala_id);
	}

	public void eliminar(int sala_id) throws DAOExcepcion {
		SalaDAO dao = new SalaDAO();
		dao.eliminar(sala_id);
	}

	public Sala acutalizar(int sala_id, String nombre, int capacidad,
			String caracteristicas, double costo, int local_id, String estado)
			throws DAOExcepcion {
		SalaDAO dao = new SalaDAO();

		Sala sala = new Sala();
		sala.setSalaId(sala_id);
		sala.setNombre(nombre);
		sala.setCapacidad(capacidad);
		sala.setCaracteristicas(caracteristicas);
		sala.setCosto(costo);

		LocalDAO daol = new LocalDAO();

		sala.setLocal(daol.obtener(local_id));

		sala.setEstado(estado);

		return dao.actualizar(sala);
	}

	public Collection<Sala> lista() throws DAOExcepcion {
		SalaDAO dao = new SalaDAO();
		return dao.listar();
	}

	public Collection<Sala> buscarPorNombre(String nombre) throws DAOExcepcion {
		SalaDAO dao = new SalaDAO();
		return dao.buscarPorNombre(nombre);
	}

}
