package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Inscrito;
import studio7i.util.ConexionBD;

public class InscritoDAO extends BaseDAO {

	
	//solo puede insertar
	public Inscrito insertar(Inscrito in)throws DAOExcepcion{
		String query = "insert into inscrito(evento_id, persona_id,fecha, presentacion) values(?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, in.getEvento().getEvento_id());
			stmt.setInt(2, in.getPersona().getPersona_id());
			stmt.setString(3, in.getFecha());
			stmt.setString(4, in.getPresentacion());
			
			int i = stmt.executeUpdate();
			if(i != 1){
				throw new SQLException("No se pudo insertar");
			}
			
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}finally{
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return in;
	}
	
			
	
}
