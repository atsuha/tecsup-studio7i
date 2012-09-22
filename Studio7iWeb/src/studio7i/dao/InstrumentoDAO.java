package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.util.ConexionBD;

public class InstrumentoDAO extends BaseDAO {

	public Instrumento insertar(Instrumento vo)throws DAOExcepcion { 
		String query = "insert into instrumento(tipo,marca,modelo,caracteristicas,precio) values (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getTipo());
			stmt.setString(2,vo.getModelo());
			stmt.setString(3, vo.getMarca());
			stmt.setString(4, vo.getCaracteristicas());
			stmt.setDouble(5, vo.getPrecio());
											
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
	

	public Instrumento obtener(int instrumento_id) throws DAOExcepcion {
		Instrumento vo = new Instrumento();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select instrumento_id, tipo, marca,modelo, caracteristicas,precio from instrumento where instrumento_id=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, instrumento_id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setInstrumento_id(rs.getInt(1));				
				vo.setTipo(rs.getString(2));
				vo.setModelo(rs.getString(3));
				vo.setMarca(rs.getString(4));
				vo.setCaracteristicas(rs.getString(5));
				vo.setPrecio(rs.getDouble(6));										
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
}
