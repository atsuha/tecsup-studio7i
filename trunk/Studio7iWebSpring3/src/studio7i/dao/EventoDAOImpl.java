package studio7i.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Objects;

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

		String sql = "select evento_id, nombre, descripcion, lugar, fecha, premios"
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
	
	

	@SuppressWarnings("unchecked")
	public Evento obtenerPorId(String evento_id)throws DAOExcepcion{
		System.out.println("EvenetoDAOImpl: obtenerPorId(): " + evento_id);
		
		String sql = "select evento_id, nombre, descripcion, lugar, fecha, premios from evento where evento_id=?";
		
		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
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
	return (Evento) jdbcTemplate.queryForObject(sql, new Object[] {evento_id, "1"}, mapper);
	}
	
	
	public void eliminar(String evento_id)throws DAOExcepcion{
		String query = "delete from evento where evento_id = ?";
	    Object[] params = new Object[] { evento_id };
		try{
			jdbcTemplate.update(query, params);
		}catch(Exception e){
			throw new DAOExcepcion(e.getMessage());
		}
	}
	
	public Evento actualizar(Evento ev)throws DAOExcepcion{
		String query = "UPDATE evento set evento_id=?, nombre = ?, descripcion = ?, lugar = ?, fecha = ?, premios = ? WHERE evento_id = ?";
		Object[] paramas = new Object[]{ev.getEvento_id(), ev.getNombre(), ev.getDescripcion(), ev.getLugar(), ev.getFecha(), ev.getPremios()};
		
		try{
			jdbcTemplate.update(query, paramas);
		}catch(Exception e){
			throw new DAOExcepcion(e.getMessage());
		}
		return ev;
	}
	
}
