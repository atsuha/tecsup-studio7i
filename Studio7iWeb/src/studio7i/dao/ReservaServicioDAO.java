
package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.ReservaServicio;
import studio7i.modelo.Servicio;

public class ReservaServicioDAO extends BaseDAO{
	
	// a este metodo se le pasa el con para poder insertar en detalle
	public ReservaServicio insertar(ReservaServicio vo, Connection con) throws DAOExcepcion{
		
		String query = "insert into reserva_servicio (servicio_id, reserva_id) values (?,?)";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			ServicioDAO sd = new ServicioDAO();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, 1);//vo.getOservicio().getServicio_id());
			stmt.setInt(2, vo.getOreserva().getReserva_id());
									
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
		}
		return vo;
	}
	
}
