package studio7i.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;


@Repository
public class EventoDAOImpl implements EventoDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Evento insertar(Evento ev)throws  DAOExcepcion{
		System.out.println("insertar");
		String query = "insert into evento(evento_id, nombre, descripcion, lugar, fecha, premios) values(?,?,?,?,?,?)";
		Object[] params = new Object[] {ev.getEvento_id(), ev.getNombre(), ev.getDescripcion(), ev.getLugar(), ev.getFecha(), ev.getPremios()};
		try{
			jdbcTemplate.update(query, params);
		}catch(Exception e){
			throw new DAOExcepcion(e.getMessage());
		}
		return ev;
	}
}
