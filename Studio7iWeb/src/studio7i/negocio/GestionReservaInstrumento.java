package studio7i.negocio;

import java.util.Collection;

import studio7i.dao.ReservaInstrumentoDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Reserva;
import studio7i.modelo.ReservaInstrumento;

public class GestionReservaInstrumento {
	
	public Collection<ReservaInstrumento> buscarPorReserva(Reserva oreserva)
			throws DAOExcepcion {
		ReservaInstrumentoDAO dao = new ReservaInstrumentoDAO();
		return dao.buscarPorReserva(oreserva);
	}

	public Collection<ReservaInstrumento> buscarPorReservaId(int reserva_id)
			throws DAOExcepcion {
		ReservaInstrumentoDAO dao = new ReservaInstrumentoDAO();
		return dao.buscarPorReservaId(reserva_id);
	}
	
}
