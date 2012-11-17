package studio7i.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Servicio;
import studio7i.modelo.Local;
import studio7i.modelo.Sala;

@Repository
public class ServicioDAOImpl implements ServicioDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	private LocalDAO local;

	public void setLocal(LocalDAO local) {
		this.local = local;
	}

	@SuppressWarnings(value = "unchecked")
	public Collection<Servicio> buscarPorDescripcion(String descripcion) throws DAOExcepcion {
		System.out.println("InstrumentoDAOImpl: BuscarPorTipo() : " + descripcion);

		String sql = "select servicio.*, local.nombre as local from servicio,local where servicio.descripcion like ? and local.local_id=servicio.local_id";
		
		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Servicio vo = new Servicio();
				vo.setServicio_id(rs.getInt("servicio_id"));
				vo.setDescripcion(rs.getString("descripcion"));
				vo.setPrecio_hora(rs.getDouble("precio_hora"));
				try {
					vo.setLocal(local.obtener(rs.getInt("local_id")));
				} catch (DAOExcepcion e) {
					e.printStackTrace();
				}
				return vo;
			}
		};
		return jdbcTemplate.query(sql, new Object[] { "%" + descripcion + "%" },
				mapper);
	}

	public Servicio insertar(Servicio vo) throws DAOExcepcion {
		System.out.println("insertar");
		String query = "insert into servicio(descripcion,precio_hora,local_id) values (?,?,?)";
			
		Object[] params = new Object[] { vo.getDescripcion(),vo.getPrecio_hora(),vo.getLocal().getLocal_id()};
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return vo;
	}

	@SuppressWarnings("unchecked")
	public Servicio obtener(int servicio_id) throws DAOExcepcion {
		System.out.println("ServicioDAOImpl: obtener() : " + servicio_id);

		String sql = "select servicio_id,descripcion, precio_hora,local_id from servicio where servicio_id=?";

		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Servicio vo=new Servicio();
				vo.setServicio_id(rs.getInt(1));
				vo.setDescripcion(rs.getString(2));
				vo.setPrecio_hora(rs.getDouble(3));
				try {
					vo.setLocal(local.obtener(rs.getInt("local_id")));
				} catch (DAOExcepcion e) {
					
					e.printStackTrace();
				}
				return vo;
			}
		};

		return (Servicio) jdbcTemplate.queryForObject(sql, new Object[] {
				servicio_id}, mapper);
	}

	public void eliminar(int servicio_id) throws DAOExcepcion {
		String query = "delete from servicio WHERE servicio_id=?";
		Object[] params = new Object[] { servicio_id };
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		
	}

	public Servicio actualizar(Servicio vo) throws DAOExcepcion {
		String query = "update servicio set descripcion=?,precio_hora=?,local_id=?  where servicio_id=?";
			
		Object[] params = new Object[] {vo.getDescripcion(), vo.getPrecio_hora(),vo.getLocal().getLocal_id(),vo.getServicio_id()};
		System.out.println("actualizar servicio");
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return vo;
	}

	public Collection<Servicio> listar() throws DAOExcepcion {
		String query = "select servicio_id,descripcion,precio_hora,local_id from servicio order by descripcion";
		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Servicio vo = new Servicio();
				vo.setServicio_id(rs.getInt("servicio_id"));
				vo.setDescripcion(rs.getString("descripcion"));
				vo.setPrecio_hora(rs.getDouble("precio_hora"));
				try {
					vo.setLocal(local.obtener(rs.getInt("local_id")));
				} catch (DAOExcepcion e) {
					e.printStackTrace();
				}
				return vo;
			}
		};
		return jdbcTemplate.query(query, mapper);
	}
	
	

}
