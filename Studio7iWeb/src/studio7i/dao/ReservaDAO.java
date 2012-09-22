package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Reserva;
import studio7i.util.ConexionBD;

public class ReservaDAO extends BaseDAO{
	
	public Reserva insertar(Reserva vo)throws DAOExcepcion { 
		String query = "insert into instrumento(fecha, alquilado, hora_inicio, hora_fin) values (?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getFecha());
			
			stmt.setInt(2,vo.getAlquilado());
			stmt.setInt(3, vo.getHora_inicio());
			stmt.setInt(4, vo.getHora_fin());
														
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
			vo.setReserva_id(id);

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
	

	public Reserva obtener(int reserva_id) throws DAOExcepcion {
		Reserva vo = new Reserva();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select reserva_id, fecha, alquilado, hora_inicio, hora_fin where reserva_id=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, reserva_id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setReserva_id(rs.getInt(1));				
				vo.setFecha(rs.getString(2));
				vo.setAlquilado(rs.getInt(3));
				vo.setHora_inicio(rs.getInt(4));
				vo.setHora_fin(rs.getInt(5));
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
