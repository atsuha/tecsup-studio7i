package studio7i.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Sala;
import trastienda.modelo.Usuario;

@Repository
public class SalaDAOImpl implements SalaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Sala validar(String idUsuario, String clave) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sala insertar(Sala vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings(value = "unchecked")
	public Collection<Sala> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		System.out.println("SalaDAOImpl: buscarPorNombre() : " + nombre);

		String sql = "select sala_id,nombre,capacidad,caracteristicas,costo,local_id,estado "
				+ " from sala where nombre like ? ";

		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Sala vo = new Sala();
				vo.setSalaId(rs.getInt("sala_id"));
				vo.setNombre(rs.getString("nombre"));
				vo.setCapacidad(rs.getInt("capacidad"));
				vo.setCaracteristicas(rs.getString("caracteristicas"));
				vo.setCosto(rs.getDouble("costo"));
				vo.setLocal(local) (rs.getString("local_id"));
				vo.setEstado(rs.getString("estado"));
				return vo;
			}
		};
		return jdbcTemplate.query(sql, new Object[] { "%" + nombre + "%" },
				mapper);
	}



}
