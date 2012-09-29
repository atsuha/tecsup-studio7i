package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;
import studio7i.util.ConexionBD;

public class EventoDAO extends BaseDAO{
	
	//metodo insertar
	public Evento insertar(Evento ev)throws DAOExcepcion {
		String query = "insert into evento(nombre, descripcion, lugar, fecha, premios) values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, ev.getNombre());
			stmt.setString(2, ev.getDescripcion());
			stmt.setString(3, ev.getLugar());
			stmt.setString(4, ev.getFecha());
			stmt.setString(5, ev.getPremios());
			
			int i = stmt.executeUpdate();
			if(i != 1){
				throw new SQLException("No se pudo insertar");
			}
			
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			ev.setEvento_id(id);
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}finally{
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		
		return ev;
		
	}

	//metodo eliminar
	public void eliminar(int evento_id)throws DAOExcepcion {
		
		String query = "delete from evento WHERE evento_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1,evento_id);
			int i = stmt.executeUpdate();
			if(i !=1){
				throw new SQLException("No se pudo eliminar");
			}
		}catch (SQLException e){
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}finally{
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
	}
	
	//nombre, descripcion, lugar, fecha, premios
	//metodo buscar
	public Evento buscar(int evento_id)throws DAOExcepcion{
		Evento ev = new Evento();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String query = "select evento_id, nombre, descripcion,lugar,fecha,premios from evento WHERE evento_id=?";
			con=ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, evento_id);
			rs = stmt.executeQuery();
			if(rs.next()){
				ev.setEvento_id(rs.getInt(1));
				ev.setNombre(rs.getString(2));
				ev.setDescripcion(rs.getString(3));
				ev.setLugar(rs.getString(4));
				ev.setFecha(rs.getString(5));
				ev.setPremios(rs.getString(6));
			}
		} catch (SQLException e){
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}finally{
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return ev;
		
	}
	

	public Evento actualizar(Evento ev) throws DAOExcepcion{
		
		String query = "update evento set nombre=?, descripcion = ?, lugar = ?, fecha = ?, premios = ? where evento_id = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, ev.getNombre());
			stmt.setString(2,ev.getDescripcion());
			stmt.setString(3, ev.getLugar());
			stmt.setString(4, ev.getFecha());
			stmt.setString(5, ev.getPremios());
			stmt.setInt(6, ev.getEvento_id());
			
			int i = stmt.executeUpdate();
			if (i != 1){
				throw new SQLException("No se pudo actualizar");
			}
		}catch (SQLException e){
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}finally{
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return ev;
		
	}
	
	
	
	public Collection<Evento> listar() throws DAOExcepcion{
		Collection<Evento> c = new ArrayList<Evento>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = ConexionBD.obtenerConexion();
			String query = "select evento_id, nombre, descripcion, lugar, fecha, premios from evento order by nombre";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()){
				Evento ev = new Evento();
				ev.setEvento_id(rs.getInt("evento_id"));
				ev.setNombre(rs.getString("nombre"));
				ev.setDescripcion(rs.getString("descripcion"));
				ev.setLugar(rs.getString("lugar"));
				ev.setFecha(rs.getString("fecha"));
				ev.setPremios(rs.getString("premios"));
				c.add(ev);
			}
		}catch (SQLException e){
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}finally{
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}
	
	

	
}
