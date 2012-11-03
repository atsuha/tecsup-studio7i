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
	public Collection<Local> buscarPorNombre(String nombre) {
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

	@Override
	public Local insertar(Local vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Local obtener(int idLocal) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int idLocal) throws DAOExcepcion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Local actualizar(Local vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Local> listar() throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
