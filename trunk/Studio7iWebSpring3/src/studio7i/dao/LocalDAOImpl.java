package studio7i.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Local;

@Repository
public class LocalDAOImpl implements LocalDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings(value = "unchecked")
	public Collection<Local> buscarPorNombre(String nombre) throws DAOExcepcion {
		System.out.println("LocalDAOImpl: buscarPorNombre() : " + nombre);

		String sql = "select local_id,nombre,direccion,estado "
				+ " from local where nombre like ? ";

		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Local vo = new Local();
				vo.setLocal_id(rs.getInt("local_id"));
				vo.setNombre(rs.getString("nombre"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setEstado(rs.getString("estado"));
				return vo;
			}
		};
		return jdbcTemplate.query(sql, new Object[] { "%" + nombre + "%" },
				mapper);
	}

	public Local insertar(Local vo) throws DAOExcepcion {
		System.out.println("insertar");
		String query = "INSERT INTO local (nombre,direccion) "
				+ "VALUES (?,?)";
		Object[] params = new Object[] { vo.getNombre(), vo.getDireccion() };
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return vo;
	}

	@SuppressWarnings("unchecked")
	public Local obtener(int idLocal) throws DAOExcepcion {
		System.out.println("LocalDAOImpl: obtener() : " + idLocal);

		String sql = "select local_id,nombre,direccion,estado from local where local_id=? and estado=?";

		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Local vo = new Local();
				vo.setLocal_id(rs.getInt("local_id"));
				vo.setNombre(rs.getString("nombre"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setEstado(rs.getString("estado"));
				return vo;
			}
		};

		return (Local) jdbcTemplate.queryForObject(sql, new Object[] {
				idLocal, "1" }, mapper);
	}

	public void eliminar(int idLocal) throws DAOExcepcion {
		String query = "UPDATE usuario SET estado=0 WHERE local_id=?";
		Object[] params = new Object[] { idLocal };
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		
	}

	public Local actualizar(Local vo) throws DAOExcepcion {
		String query = "UPDATE local SET nombre=?, direccion=?"
				+ " WHERE local_id=?";
		Object[] params = new Object[] { vo.getNombre(), vo.getDireccion(), vo.getLocal_id() };
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return vo;
	}

	public Collection<Local> listar() throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
