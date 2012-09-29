package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Local;
import studio7i.util.ConexionBD;


public class LocalDAO  extends BaseDAO {
	
	public Collection<Local> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select local_id, nombre, direccion from local where nombre like ?";
		Collection<Local> lista = new ArrayList<Local>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Local vo = new Local();
				vo.setLocal_id(rs.getInt("local_id"));
				vo.setNombre(rs.getString("nombre"));
				vo.setDireccion(rs.getString("direccion"));
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(lista.size());
		return lista;
	}

	public Local insertar(Local vo) throws DAOExcepcion {
		String query = "insert into local(nombre,direccion) values (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDireccion());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			vo.setLocal_id(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public Local obtener(int idLocal) throws DAOExcepcion {
		Local vo = new Local();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select local_id, nombre, direccion from local where local_id=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idLocal);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setLocal_id(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setDireccion(rs.getString(3));
				//vo.setSalas(salas);
				//vo.setInstrumentos(instrumentos);
				//vo.setServicios(servicios);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public void eliminar(int idLocal) throws DAOExcepcion {
		String query = "delete from local WHERE local_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idLocal);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public Local actualizar(Local vo) throws DAOExcepcion {
		String query = "update local set nombre=?,direccion=? where local_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDireccion());
			stmt.setInt(3, vo.getLocal_id());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public Collection<Local> listar() throws DAOExcepcion {
		Collection<Local> c = new ArrayList<Local>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select local_id, nombre, direccion from local order by nombre";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Local vo = new Local();
				vo.setLocal_id(rs.getInt("local_id"));
				vo.setNombre(rs.getString("nombre"));
				vo.setDireccion(rs.getString("direccion"));
				c.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}


}
