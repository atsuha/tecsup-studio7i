package studio7i.negocio;

import java.util.Date;
import java.util.Collection;

import studio7i.dao.ReservaDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Persona;
import studio7i.modelo.Reserva;
import studio7i.modelo.ReservaInstrumento;
import studio7i.modelo.ReservaServicio;
import studio7i.modelo.Sala;

public class GestionReserva {

	public Reserva insertar(int hora_inicio, Date fecha, int hora_fin, int alquilado, int salaId,
							int persona_id, Collection <ReservaInstrumento> listainstrumentos,
							Collection <ReservaServicio> listaservicios)throws DAOExcepcion {
				
		ReservaDAO dao = new ReservaDAO();
		
		Sala s1	= new Sala();
		s1.setSalaId(salaId);
		
		Persona p1 = new Persona();
		p1.setPersona_id(persona_id);
		
		Reserva vo = new Reserva();
		vo.setHora_inicio(hora_inicio);
		vo.setHora_fin(hora_fin);
		vo.setFecha(fecha);
		vo.setAlquilado(alquilado);
		vo.setOpersona(p1);
		vo.setOsala(s1);	
		
		//Reserva_instrumento y Reserva_Servicio
		
		vo.setListainstrumentos(listainstrumentos);
		vo.setListaservicios(listaservicios);
//		Instrumento i1 = new Instrumento();
//		i1.setInstrumento_id(1);
//					
//		Servicio serv1 = new Servicio();
//		serv1.setServicio_id(1);
//		return dao.insertar(vo);
		try {
			return dao.insertar(vo);
		} catch (Exception e) {
			throw e;
		}
		
		
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
