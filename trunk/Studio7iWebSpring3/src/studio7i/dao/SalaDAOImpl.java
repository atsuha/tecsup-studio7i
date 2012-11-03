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

@Repository
public class SalaDAOImpl implements SalaDAO {

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

	@Override
	public Sala insertar(Sala vo) throws DAOExcepcion{
		// TODO Auto-generated method stub
		String query = "INSERT INTO sala(nombre,capacidad,caracteristicas,costo,local_id) VALUES (?,?,?,?,?) ";
		Object[] params = new Object[] { vo.getNombre(), vo.getCapacidad(),
				vo.getCaracteristicas(), vo.getCosto(),
				vo.getLocal().getLocal_id() };
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return vo;
	}
	
	@Override
	public Sala obener(String id) throws DAOExcepcion{		
		String query = "select sala_id,nombre,capacidad,caracteristicas,costo,local_id from sala where estado=1 AND sala_id=? ";
		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Sala vo = new Sala();
				vo.setSalaId(rs.getInt(1));				
				vo.setNombre(rs.getString(2));
				vo.setCapacidad(rs.getInt(3));
				vo.setCaracteristicas(rs.getString(4));
				vo.setCosto(rs.getDouble(5));
				try {
					vo.setLocal(local.obtener(rs.getInt(6)));
				} catch (DAOExcepcion e) {
					e.printStackTrace();
				}
				return vo;
			}
		};

		return (Sala) jdbcTemplate.queryForObject(query, new Object[] {
				id, "1" }, mapper);
	}
	
	public void eliminar(String id) throws DAOExcepcion{
		String query = "update sala set estado=0 where sala_id=?";
		Object[] params = new Object[] {id};
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}				
	}
	
	@Override
	public Sala actualizar(Sala vo) throws DAOExcepcion{
		String query = "update sala set nombre=?,capacidad=?,caracteristicas=?,costo=?,local_id=? where sala_id=?";
		Object[] params = new Object[] { vo.getNombre(), vo.getCapacidad(),
				vo.getCaracteristicas(), vo.getCosto(), vo.getLocal().getLocal_id(),
				vo.getSalaId() };
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return vo;
	}
	
	@Override
	public Collection<Sala> listar() throws DAOExcepcion{
		String query = "select sala_id,nombre,capacidad,caracteristicas,costo,local_id from sala where estado!=0 order by nombre";
		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Sala vo = new Sala();
				vo.setSalaId(rs.getInt("sala_id"));
				vo.setNombre(rs.getString("nombre"));
				vo.setCapacidad(rs.getInt("capacidad"));
				vo.setCaracteristicas(rs.getString("caracteristicas"));
				vo.setCosto(rs.getDouble("costo"));
				try {
					vo.setLocal(local.obtener(rs.getInt(6)));
				} catch (DAOExcepcion e) {
					e.printStackTrace();
				}
				return vo;
			}
		};
		return jdbcTemplate.query(query, mapper);
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
				try {
					vo.setLocal(local.obtener(rs.getInt("local_id")));
				} catch (DAOExcepcion e) {
					e.printStackTrace();
				}
				vo.setEstado(rs.getString("estado"));
				return vo;
			}
		};
		return jdbcTemplate.query(sql, new Object[] { "%" + nombre + "%" },
				mapper);
	}
	
	@SuppressWarnings(value = "unchecked")
	public Collection<Sala> buscarPorSalaId(String id) throws DAOExcepcion{
		String query = "select sala_id,nombre,capacidad,caracteristicas,costo,local_id from sala where sala_id = ? and estado!=0 order by nombre";
		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Sala vo = new Sala();
				vo.setSalaId(rs.getInt("sala_id"));
				vo.setNombre(rs.getString("nombre"));
				vo.setCapacidad(rs.getInt("capacidad"));
				vo.setCaracteristicas(rs.getString("caracteristicas"));
				vo.setCosto(rs.getDouble("costo"));
				try {
					vo.setLocal(local.obtener(rs.getInt(6)));
				} catch (DAOExcepcion e) {
					e.printStackTrace();
				}
				return vo;
			}
		};
		return jdbcTemplate.query(query, new Object[] {id, "1" }, mapper);
//		return jdbcTemplate.query(query, new Object[] { "%" + nombre + "%" },
//				mapper);
	}
	
}
