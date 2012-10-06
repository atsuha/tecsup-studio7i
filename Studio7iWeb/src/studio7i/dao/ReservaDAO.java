package studio7i.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.modelo.Reserva;
import studio7i.modelo.ReservaInstrumento;
import studio7i.util.ConexionBD;
import studio7i.dao.BaseDAO;

public class ReservaDAO extends BaseDAO {
	
	public Reserva insertar(Reserva vo)throws DAOExcepcion { 
		String query 			= "insert into Reserva(hora_inicio, fecha, hora_fin, alquilado,persona_id,sala_id) values (?,?,?,?,?,?)";
		Connection con 			= null;
		PreparedStatement stmt 	= null;
		ResultSet rs 			= null;
	
		try {
			con 	= ConexionBD.obtenerConexion();
			stmt 	= con.prepareStatement(query);
			stmt.setInt(1, vo.getHora_inicio());
			stmt.setString(2,vo.getFechaString());
			stmt.setInt(3, vo.getHora_fin());
			stmt.setInt(4, vo.getAlquilado());
			stmt.setInt(5,vo.getOpersona().getPersona_id());
			stmt.setInt(6, vo.getOsala().getSalaId());			
			
			int i 	= stmt.executeUpdate();
			if (i 	!= 1) {
				throw new SQLException("No se pudo insertar");
			}
			// Obtener el ultimo id
			int id 	= 0;
			query 	= "select last_insert_id()";
			stmt 	= con.prepareStatement(query);
			rs 		= stmt.executeQuery();
			if (rs.next()) {
				id 	= rs.getInt(1);
			}
			vo.setReserva_id(id);
			
			for (ReservaInstrumento inst : vo.getReservainstrumento()){
				query 	= "INSERT INTO reserva_instrumento(reserva_id,instrumento_id, estado) VALUES (?,?,?)";
							
				stmt 	= con.prepareStatement(query);
				stmt.setInt(1, id);
				stmt.setInt(2, inst.getOinstrumento().getInstrumento_id());
				stmt.setString(4, inst.getEstado());

				int u 	= stmt.executeUpdate();
				if (u 	!= 1) {
					throw new SQLException("No se pudo insertar la reserva del Instrumento");
				}
				
			}
			con.commit();	
		} 		
		catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new DAOExcepcion(e.getMessage());
			}
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				throw new DAOExcepcion(e.getMessage());
			}
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;	
			
	}
	
		
	
	//Consulta
	public Reserva obtener(int reserva_id) throws DAOExcepcion {
		Reserva vo = new Reserva();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//Local lo =new Local();
		
		try {
			String query = "select reserva_id, hora_inicio, fecha, hora_fin, alquilado from reserva where reserva_id=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, reserva_id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setReserva_id(rs.getInt(1));
				vo.setHora_inicio(rs.getInt(2));
				vo.setFecha(rs.getDate(3));
				vo.setHora_fin(rs.getInt(4));
				vo.setAlquilado(rs.getInt(5));
												
				//vo.setLocal(lo.obtener(rs.getInt(7)));
				
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


	public Reserva actualizar(Reserva vo)throws DAOExcepcion { 
		String query = "update reserva set hora_inicio=?,fecha=?,hora_fin=?,alquilado=? where reserva_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getHora_inicio());
			stmt.setString(2,  vo.getFechaString());
			stmt.setInt(3, vo.getHora_fin());
			stmt.setInt(4, vo.getAlquilado());
			stmt.setInt(5, vo.getReserva_id());
			
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


	public Collection<Reserva> listar() throws DAOExcepcion {
		Collection<Reserva>c=new ArrayList<Reserva>();
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
	 try{
		 con=ConexionBD.obtenerConexion();
		 String query="select reserva_id,hora_inicio,fecha,hora_fin,alquilado from reserva order by alquilado";
		 stmt=con.prepareStatement(query);
		 rs=stmt.executeQuery();
		 while(rs.next()){
			 Reserva vo =new Reserva();
			 vo.setReserva_id(rs.getInt("reserva_id"));
			 vo.setHora_inicio(rs.getInt("hora_inicio"));
			 vo.setFecha(rs.getDate("fecha"));
			 vo.setHora_fin(rs.getInt("hora_fin"));
			 vo.setAlquilado(rs.getInt("alquilado"));
			 
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


	public void eliminar(int reserva_id)throws DAOExcepcion {
		String query = "delete from reserva WHERE reserva_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, reserva_id);
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

}
