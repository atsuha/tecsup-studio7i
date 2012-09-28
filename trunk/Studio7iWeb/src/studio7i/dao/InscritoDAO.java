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
		String query = "insert into inscrito(evento, persona,fecha, presentacion) values(?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, in.getFecha());
			stmt.setString(2, in.getPresentacion());
			stmt.setInt(3, in.getEvento().getEvento_id());
			//si es agregado PK persona_id se cambia
			stmt.setString(4, in.getPersona().getUsuario());
			
			int i = stmt.executeUpdate();
			if(i != 1){
				throw new SQLException("No se pudo insertar");
			}
			
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()){
				id = rs.getInt(1);
			}
			//poner id, solo pk's ?
			//in.setEvento(evento);
			
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
