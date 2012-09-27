package studio7i.negocio;

import java.util.Collection;

import studio7i.dao.ReservaDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Reserva;

public class GestionReserva {

	public Reserva insertar(int hora_inicio, String fecha, int hora_fin, int alquilado)
//	eserva_id, sala_id, persona_id, hora_inicio, fecha, hora_fin, alquilado

		throws DAOExcepcion {
				
		ReservaDAO dao = new ReservaDAO();

		Reserva vo = new Reserva();
		
		vo.setHora_inicio(hora_inicio);
		vo.setHora_fin(hora_fin);
		vo.setFecha(fecha);
		vo.setAlquilado(alquilado);
		
		
		return dao.insertar(vo);				
	}

	public Reserva obtener(int reserva_id) throws DAOExcepcion {
		ReservaDAO dao = new ReservaDAO();
		return dao.obtener(reserva_id);
	}

	public Reserva actualizar(int reserva_id, int hora_inicio, String fecha,
			int hora_fin, int alquilado)throws DAOExcepcion {
				
		ReservaDAO dao =new ReservaDAO();
		
		Reserva vo=new Reserva();
		vo.setHora_inicio(hora_inicio);
		vo.setFecha(fecha);
		vo.setHora_fin(hora_fin);
		vo.setAlquilado(alquilado);
		vo.setReserva_id(reserva_id);
		return dao.actualizar(vo);	
	
	}

	public Collection<Reserva> listar() throws DAOExcepcion {
		ReservaDAO dao =new ReservaDAO();
		return dao.listar();
	}

	public void eliminar(int reserva_id) throws DAOExcepcion {
		ReservaDAO dao = new ReservaDAO();
		dao.eliminar(reserva_id);
	}


	
}
