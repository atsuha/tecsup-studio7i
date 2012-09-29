package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Sala;
import studio7i.modelo.SalaInstrumento;
import studio7i.modelo.SalaServicio;
import studio7i.util.ConexionBD;

public class SalaDAO extends BaseDAO {
	
	public Sala insertar(Sala vo)throws DAOExcepcion{
		String query = "insert into sala(nombre,capacidad,caracteristicas,costo,local_id) values (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setInt(2,vo.getCapacidad());
			stmt.setString(3, vo.getCaracteristicas());
			stmt.setDouble(4, vo.getCosto());
			stmt.setInt(5, vo.getLocal().getLocal_id());
											
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
			vo.setSalaId(id);
			
			// creando el objeto sala
			Sala sala = new Sala();
			sala.setSalaId(id);
			
			SalaInstrumentoDAO daoi = new SalaInstrumentoDAO();
			SalaServicioDAO daos = new SalaServicioDAO();
			for(SalaServicio serv : vo.getListaServicios()){
				SalaServicio sv = new SalaServicio();
				sv.setSala(sala);
				sv.setServicio(serv.getServicio());
				daos.insertar(sv,con);
			}
			
			for(SalaInstrumento ins : vo.getListaInstrumentos()){
				SalaInstrumento si = new SalaInstrumento();
				si.setInstrumento(ins.getInstrumento());
				si.setSala(sala);
				daoi.insertar(si,con);
			}
			con.commit();
		}catch (SQLException e) {
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
	
	public Sala obtener(int sala_id)throws DAOExcepcion{
		Sala vo = new Sala();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LocalDAO local =new LocalDAO();
		
		try {
			String query = "select sala_id,nombre,capacidad,caracteristicas,costo,local_id from sala where estado=1 AND sala_id=? ";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, sala_id);
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setSalaId(rs.getInt(1));				
				vo.setNombre(rs.getString(2));
				vo.setCapacidad(rs.getInt(3));
				vo.setCaracteristicas(rs.getString(4));
				vo.setCosto(rs.getDouble(5));
				vo.setLocal(local.obtener(rs.getInt(6)));
				
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
	
	public void eliminar(int sala_id)throws DAOExcepcion{
		String query = "update sala set estado=0 where sala_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, sala_id);
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
	}
	
	public Sala actualizar(Sala vo) throws DAOExcepcion {
		String query = "update sala set nombre=?,capacidad=?,caracteristicas=?,costo=?,local_id=? where sala_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setInt(2, vo.getCapacidad());
			stmt.setString(3, vo.getCaracteristicas());
			stmt.setDouble(4, vo.getCosto());
			stmt.setInt(5,vo.getLocal().getLocal_id());
			stmt.setInt(6, vo.getSalaId());
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
	
	public Collection<Sala> listar() throws DAOExcepcion {
		Collection<Sala> c = new ArrayList<Sala>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LocalDAO local =new LocalDAO();
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select sala_id,nombre,capacidad,caracteristicas,costo,local_id from sala order by nombre";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Sala vo = new Sala();
				vo.setSalaId(rs.getInt("sala_id"));
				vo.setNombre(rs.getString("nombre"));
				vo.setCapacidad(rs.getInt("capacidad"));
				vo.setCaracteristicas(rs.getString("caracteristicas"));
				vo.setCosto(rs.getDouble("costo"));
				vo.setLocal(local.obtener(rs.getInt(6)));
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
