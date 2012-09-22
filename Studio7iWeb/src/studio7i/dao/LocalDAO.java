package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Local;
import studio7i.util.ConexionBD;

public class LocalDAO  extends BaseDAO {
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


}
