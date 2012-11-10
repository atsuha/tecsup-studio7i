package studio7i.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.modelo.Local;
import studio7i.modelo.Sala;

@Repository
public class InstrumentoDAOImpl implements InstrumentoDAO{
	
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
	public Collection<Instrumento> buscarPorTipo(String tipo) throws DAOExcepcion {
		System.out.println("InstrumentoDAOImpl: BuscarPorTipo() : " + tipo);

		String sql = "select instrumento.*, local.nombre as local from instrumento, local where instrumento.tipo like ? and local.local_id=instrumento.local_id";
		
		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Instrumento vo = new Instrumento();
				vo.setInstrumento_id(rs.getInt("instrumento_id"));
				vo.setTipo(rs.getString("tipo"));
				vo.setCaracteristicas(rs.getString("caracteristicas"));
				Local local=new Local();
				local.setLocal_id(rs.getInt("local_id"));
				local.setNombre(rs.getString("local"));
				vo.setLocal((local));
				vo.setMarca(rs.getString("marca"));
				vo.setModelo(rs.getString("modelo"));
				vo.setPrecio(rs.getDouble("precio"));
				return vo;
			}
		};
		return jdbcTemplate.query(sql, new Object[] { "%" + tipo + "%" },
				mapper);
	}

	public Instrumento insertar(Instrumento vo) throws DAOExcepcion {
		System.out.println("insertar");
		String query = "insert into instrumento(tipo,marca,modelo,caracteristicas,precio,local_id) values (?,?,?,?,?,?)";
			
		Object[] params = new Object[] { vo.getTipo(),vo.getModelo(),vo.getMarca(),vo.getCaracteristicas(),vo.getPrecio(),vo.getLocal().getLocal_id()};
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return vo;
	}

	@SuppressWarnings("unchecked")
	public Instrumento obtener(int instrumento_id) throws DAOExcepcion {
		System.out.println("InstrumentoDAOImpl: obtener() : " + instrumento_id);

		String sql = "select instrumento_id, tipo, marca,modelo, caracteristicas,precio,local_id from instrumento where instrumento_id=?";

		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Instrumento vo=new Instrumento();


				
				vo.setInstrumento_id(rs.getInt("instrumento_id"));
				vo.setTipo(rs.getString("tipo"));
				vo.setMarca(rs.getString("marca"));
				vo.setModelo(rs.getString("modelo"));
				vo.setCaracteristicas(rs.getString("caracteristicas"));
				vo.setPrecio(rs.getDouble("precio"));
				try {
					vo.setLocal(local.obtener(rs.getInt("local_id")));
				} catch (DAOExcepcion e) {
					
					e.printStackTrace();
				}
				return vo;
			}
		};

		return (Instrumento) jdbcTemplate.queryForObject(sql, new Object[] {
				instrumento_id, "1" }, mapper);
	}

	public void eliminar(int instrumento_id) throws DAOExcepcion {
		String query = "delete from instrumento WHERE instrumento_id=?";
		Object[] params = new Object[] { instrumento_id };
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		
	}

	public Instrumento actualizar(Instrumento vo) throws DAOExcepcion {
		String query = "update instrumento set tipo=?,modelo=?,marca=?,caracteristicas=?,precio=?,local_id=?  where instrumento_id=?";
			
		Object[] params = new Object[] {vo.getInstrumento_id(), vo.getTipo(),vo.getModelo(),vo.getMarca(),vo.getCaracteristicas(),vo.getPrecio(),vo.getLocal().getLocal_id()};
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			throw new DAOExcepcion(e.getMessage());
		}
		return vo;
	}

	public Collection<Instrumento> listar() throws DAOExcepcion {
		String query = "select instrumento_id, tipo, marca,modelo, caracteristicas,precio,local_id from instrumento where estado!=0";
		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Instrumento vo = new Instrumento();
				vo.setInstrumento_id(rs.getInt("instrumento_id"));
				vo.setTipo(rs.getString("tipo"));
				vo.setMarca(rs.getString("marca"));
				vo.setCaracteristicas(rs.getString("caracteristicas"));
				vo.setModelo(rs.getString("modelo"));
				vo.setPrecio(rs.getDouble("precio"));
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
	
	

}
