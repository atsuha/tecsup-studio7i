package studio7i.negocio;

import java.util.Date;
import java.util.Collection;

import studio7i.dao.ReservaDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Persona;
import studio7i.modelo.Reserva;
import studio7i.modelo.ReservaInstrumento;
import studio7i.modelo.Sala;

public class GestionReserva {

	public Reserva insertar(int hora_inicio, Date fecha, int hora_fin, int alquilado, int salaId, int persona_id, 
								Collection <ReservaInstrumento> reservainstrumento)

		throws DAOExcepcion {
				
		ReservaDAO dao = new ReservaDAO();
		Sala s1	= new Sala();
		Reserva vo = new Reserva();
		s1.setSalaId(salaId);
		
		Persona p1 = new Persona();
		p1.setPersona_id(persona_id);
		
		vo.setHora_inicio(hora_inicio);
		vo.setHora_fin(hora_fin);
		vo.setFecha(fecha);
		vo.setAlquilado(alquilado);
		vo.setOpersona(p1);
		vo.setOsala(s1);
				
		//Reserva_instrumento
		
		vo.setReservainstrumento(reservainstrumento);
				
		return dao.insertar(vo);
		
		
	}
	
	public Reserva obtener(int reserva_id) throws DAOExcepcion {
		ReservaDAO dao = new ReservaDAO();
		return dao.obtener(reserva_id);
	}

	public Reserva actualizar(int reserva_id, int hora_inicio, Date fecha,
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
