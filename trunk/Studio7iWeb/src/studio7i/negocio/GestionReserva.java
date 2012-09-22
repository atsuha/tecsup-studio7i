package studio7i.negocio;

import studio7i.dao.ReservaDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Reserva;

public class GestionReserva {
	
	public Reserva insertar(String fecha, int alquilado, int hora_inicio, int hora_fin)
			throws DAOExcepcion {
		
		ReservaDAO dao = new ReservaDAO();

		Reserva vo = new Reserva();
		vo.setAlquilado(alquilado);
		vo.setFecha(fecha);
		vo.setHora_inicio(hora_inicio);
		vo.setHora_fin(hora_fin);
		
		return dao.insertar(vo);				
	}

	public Reserva obtener(int reserva_id) throws DAOExcepcion {
		ReservaDAO dao = new ReservaDAO();
		return dao.obtener(reserva_id);
	}


}
