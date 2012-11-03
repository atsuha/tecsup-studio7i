package studio7i.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	@SuppressWarnings(value = "unchecked")
	public Collection<Evento> buscarNombre(String nombre)
			throws DAOExcepcion {
		System.out.println("EventoDAOImpl: buscarPorNombre() : " + nombre);

		String sql = "select evento_id, nombre, descricion, lugar, fecha, premios"
				+ " from evento where nombre like ? ";

		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Evento ev = new Evento();
				ev.setEvento_id(rs.getInt("evento_id"));
				ev.setNombre(rs.getString("nombre"));
				ev.setDescripcion(rs.getString("descripcion"));
				ev.setLugar(rs.getString("lugar"));
				ev.setFecha(rs.getString("fecha"));
				ev.setPremios(rs.getString("premios"));
				return ev;
			}
		};
		return jdbcTemplate.query(sql, new Object[] { "%" + nombre + "%" },
				mapper);
	}

	
}
