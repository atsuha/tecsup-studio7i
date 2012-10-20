package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.modelo.Local;
import studio7i.modelo.Servicio;
import studio7i.negocio.GestionLocal;
import studio7i.util.ConexionBD;

public class ServicioDAO extends BaseDAO {

	public Servicio insertar(Servicio vo) throws DAOExcepcion {

		String query = "insert into servicio(descripcion,precio_hora,local_id) values (?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getDescripcion());
			stmt.setDouble(2, vo.getPrecio_hora());
			stmt.setInt(3, vo.getLocal().getLocal_id());

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
			vo.setServicio_id(id);

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

	public Servicio obtener(int servicio_id) throws DAOExcepcion {
		Servicio vo = new Servicio();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		GestionLocal lo = new GestionLocal();

		try {
			String query = "select servicio_id,descripcion, precio_hora,local_id from servicio where servicio_id=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, servicio_id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setServicio_id(rs.getInt(1));
				vo.setDescripcion(rs.getString(2));
				vo.setPrecio_hora(rs.getDouble(3));
				vo.setLocal(lo.obtener(rs.getInt(4)));
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

	public Servicio actualizar(Servicio vo) throws DAOExcepcion {
		String query = "update servicio set descripcion=?,precio_hora=?,local_id=?  where servicio_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getDescripcion());
			stmt.setDouble(2, vo.getPrecio_hora());
			stmt.setInt(3, vo.getLocal().getLocal_id());
			stmt.setInt(4, vo.getServicio_id());

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

	public Collection<Servicio> listar() throws DAOExcepcion {
		Collection<Servicio> c = new ArrayList<Servicio>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select servicio_id,descripcion,precio_hora,local_id from servicio order by descripcion";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Servicio vo = new Servicio();
				vo.setServicio_id(rs.getInt("servicio_id"));
				vo.setDescripcion(rs.getString("descripcion"));
				vo.setPrecio_hora(rs.getDouble("precio_hora"));
				GestionLocal lo = new GestionLocal();
				vo.setLocal(lo.obtener(rs.getInt("local_id")));

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

	// public void eliminar(int servicio_id)throws DAOExcepcion {
	// String query = "delete from servicio WHERE servicio_id=?";
	// Connection con = null;
	// PreparedStatement stmt = null;
	// try {
	// con = ConexionBD.obtenerConexion();
	// stmt = con.prepareStatement(query);
	// stmt.setInt(1, servicio_id);
	// int i = stmt.executeUpdate();
	// if (i != 1) {
	// throw new SQLException("No se pudo eliminar");
	// }
	// } catch (SQLException e) {
	// System.err.println(e.getMessage());
	// throw new DAOExcepcion(e.getMessage());
	// } finally {
	// this.cerrarStatement(stmt);
	// this.cerrarConexion(con);
	// }
	//
	// }
	//
	//
	//

	public void eliminar(int servicio_id) throws DAOExcepcion {
		String query = "update servicio set estado=? where servicio_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "0");
			stmt.setInt(2, servicio_id);
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

	public Collection<Servicio> buscarPorDescripcion(String descripcion)
			throws DAOExcepcion {
		String query = "select servicio.*, local.nombre as local from servicio,local where servicio.descripcion like ? and local.local_id=servicio.local_id";
		Collection<Servicio> c = new ArrayList<Servicio>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + descripcion + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Servicio vo = new Servicio();
				vo.setServicio_id(rs.getInt("servicio_id"));
				vo.setDescripcion(rs.getString("descripcion"));
				vo.setPrecio_hora(rs.getFloat("precio_hora"));
				Local local = new Local();
				local.setLocal_id(rs.getInt("local_id"));
				local.setNombre(rs.getString("local"));
				vo.setLocal((local));
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
