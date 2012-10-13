package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.SalaServicio;
import studio7i.util.ConexionBD;

public class SalaServicioDAO extends BaseDAO {
	
	// a este metodo se le pasa el con para poder insertar en detalle
	public SalaServicio insertar(SalaServicio vo) throws DAOExcepcion{
		Connection con = null;
		String query = "insert into sala_servicio (servicio_id,sala_id) values (?,?)";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getServicio().getServicio_id());
			stmt.setInt(2,vo.getSala().getSalaId());
			
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
