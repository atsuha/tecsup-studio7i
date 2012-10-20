package studio7i.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.modelo.Local;
import studio7i.modelo.Servicio;
import studio7i.negocio.GestionLocal;
import studio7i.util.ConexionBD;

public class InstrumentoDAO extends BaseDAO {

	public Instrumento insertar(Instrumento vo) throws DAOExcepcion {
		String query = "insert into instrumento(tipo,marca,modelo,caracteristicas,precio,local_id) values (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getTipo());
			stmt.setString(2, vo.getModelo());
			stmt.setString(3, vo.getMarca());
			stmt.setString(4, vo.getCaracteristicas());
			stmt.setDouble(5, vo.getPrecio());
			stmt.setInt(6, vo.getLocal().getLocal_id());

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
			vo.setInstrumento_id(id);

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

	// public Instrumento obtener(int instrumento_id) throws DAOExcepcion {
	// Instrumento vo = new Instrumento();
	// Connection con = null;
	// PreparedStatement stmt = null;
	// ResultSet rs = null;
	// GestionLocal lo = new GestionLocal();
	//
	// try {
	// String query =
	// "select instrumento_id, tipo, marca,modelo, caracteristicas,precio,local_id from instrumento where instrumento_id=?";
	// con = ConexionBD.obtenerConexion();
	// stmt = con.prepareStatement(query);
	// stmt.setInt(1, instrumento_id);
	// rs = stmt.executeQuery();
	// if (rs.next()) {
	// vo.setInstrumento_id(rs.getInt(1));
	// vo.setTipo(rs.getString(2));
	// vo.setModelo(rs.getString(3));
	// vo.setMarca(rs.getString(4));
	// vo.setCaracteristicas(rs.getString(5));
	// vo.setPrecio(rs.getDouble(6));
	// vo.setLocal(lo.obtener(rs.getInt(7)));
	//
	// }
	// } catch (SQLException e) {
	// System.err.println(e.getMessage());
	// throw new DAOExcepcion(e.getMessage());
	// } finally {
	// this.cerrarResultSet(rs);
	// this.cerrarStatement(stmt);
	// this.cerrarConexion(con);
	// }
	// return vo;
	// }

	public Instrumento obtener(int instrumento_id) throws DAOExcepcion {
		Instrumento vo = new Instrumento();
		Connection cons = null;
		CallableStatement callstmt = null;
		ResultSet rs = null;
		GestionLocal lo = new GestionLocal();
		try {
			String call = "{CALL sp_obtener_instrumento(?)}";
			cons = ConexionBD.obtenerConexion();
			callstmt = (CallableStatement) cons.prepareCall(call);
			callstmt.setInt(1, instrumento_id);
			
			
			
			rs = callstmt.executeQuery();
			if (rs.next()) {
				vo.setInstrumento_id(rs.getInt(1));
				vo.setTipo(rs.getString(2));
				vo.setModelo(rs.getString(3));
				vo.setMarca(rs.getString(4));
				vo.setCaracteristicas(rs.getString(5));
				vo.setPrecio(rs.getDouble(6));
				vo.setLocal(lo.obtener(rs.getInt(7)));

			}
		} catch (SQLException e) {
			throw new DAOExcepcion(e.toString());
		} catch (Exception e) {
			throw new DAOExcepcion(e.toString());
		} finally {
			cerrarCallable(callstmt);
			cerrarConexion(cons);
		}

		return vo;
	}

	public Instrumento actualizar(Instrumento vo) throws DAOExcepcion {
		String query = "update instrumento set tipo=?,modelo=?,marca=?,caracteristicas=?,precio=?,local_id=?  where instrumento_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getTipo());
			stmt.setString(2, vo.getModelo());
			stmt.setString(3, vo.getMarca());
			stmt.setString(4, vo.getCaracteristicas());
			stmt.setDouble(5, vo.getPrecio());
			stmt.setInt(6, vo.getLocal().getLocal_id());
			stmt.setInt(7, vo.getInstrumento_id());

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

	// public Collection<Instrumento> listar() throws DAOExcepcion {
	// Collection<Instrumento>c=new ArrayList<Instrumento>();
	// Connection con=null;
	// PreparedStatement stmt=null;
	// ResultSet rs=null;
	// try{
	// con=ConexionBD.obtenerConexion();
	// String
	// query="select instrumento_id,tipo,modelo,marca,caracteristicas,precio from instrumento order by tipo";
	// stmt=con.prepareStatement(query);
	// rs=stmt.executeQuery();
	// while(rs.next()){
	// Instrumento vo =new Instrumento();
	// vo.setInstrumento_id(rs.getInt("instrumento_id"));
	// vo.setTipo(rs.getString("tipo"));
	// vo.setMarca(rs.getString("marca"));
	// vo.setCaracteristicas(rs.getString("caracteristicas"));
	// vo.setModelo(rs.getString("modelo"));
	// vo.setPrecio(rs.getDouble("precio"));
	// c.add(vo);
	// }
	//
	// } catch (SQLException e) {
	// System.err.println(e.getMessage());
	// throw new DAOExcepcion(e.getMessage());
	// } finally {
	// this.cerrarResultSet(rs);
	// this.cerrarStatement(stmt);
	// this.cerrarConexion(con);
	// }
	// return c;
	// }

	public Collection<Instrumento> listar() throws DAOExcepcion {
		Collection<Instrumento> c = new ArrayList<Instrumento>();
		Connection cons = null;
		CallableStatement callstmt = null;
		ResultSet rs = null;
		try {
			String call = "{CALL sp_listar_instrumentos()}";
			cons = ConexionBD.obtenerConexion();
			callstmt = (CallableStatement) cons.prepareCall(call);
			rs = callstmt.executeQuery();
			while (rs.next()) {
				Instrumento vo = new Instrumento();
				vo.setInstrumento_id(rs.getInt("instrumento_id"));
				vo.setTipo(rs.getString("tipo"));
				vo.setMarca(rs.getString("marca"));
				vo.setCaracteristicas(rs.getString("caracteristicas"));
				vo.setModelo(rs.getString("modelo"));
				vo.setPrecio(rs.getDouble("precio"));
				c.add(vo);
			}

		} catch (SQLException e) {
			throw new DAOExcepcion(e.toString());
		} catch (Exception e) {
			throw new DAOExcepcion(e.toString());
		} finally {
			cerrarCallable(callstmt);
			cerrarConexion(cons);
		}

		return c;
	}

	// public void eliminar(int instrumento_id)throws DAOExcepcion {
	// String query = "delete from instrumento WHERE instrumento_id=?";
	// Connection con = null;
	// PreparedStatement stmt = null;
	// try {
	// con = ConexionBD.obtenerConexion();
	// stmt = con.prepareStatement(query);
	// stmt.setInt(1, instrumento_id);
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
	public void eliminar(int instrumento_id) throws DAOExcepcion {
		String query = "update instrumento set estado=? where instrumento_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "0");
			stmt.setInt(2, instrumento_id);
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
	public Collection<Instrumento> buscarPorTipo(String tipo)
			throws DAOExcepcion {
		String query = "select instrumento.*, local.nombre as local from instrumento, local where instrumento.tipo like ? and local.local_id=instrumento.local_id";
		Collection<Instrumento> c=new ArrayList<Instrumento>();
			
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + tipo + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Instrumento vo=new Instrumento();
				vo.setInstrumento_id(rs.getInt("instrumento_id"));
				vo.setTipo(rs.getString("tipo"));
				vo.setCaracteristicas(rs.getString("caracteristicas"));
				vo.setModelo(rs.getString("modelo"));
				vo.setMarca(rs.getString("marca"));	
				vo.setPrecio(rs.getFloat("precio"));
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
