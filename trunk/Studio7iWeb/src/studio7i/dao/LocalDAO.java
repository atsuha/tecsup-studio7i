package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.modelo.Local;
import studio7i.modelo.Sala;
import studio7i.modelo.Servicio;
import studio7i.util.ConexionBD;


public class LocalDAO  extends BaseDAO {
	
	public Collection<Local> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select local_id, nombre, direccion, estado from local where nombre like ?";
		Collection<Local> lista = new ArrayList<Local>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Local vo = new Local();
				vo.setLocal_id(rs.getInt("local_id"));
				vo.setNombre(rs.getString("nombre"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setEstado(rs.getString("estado"));
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(lista.size());
		return lista;
	}

	public Local insertar(Local vo) throws DAOExcepcion {
		String query = "insert into local(nombre,direccion) values (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDireccion());
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
			vo.setLocal_id(id);

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

	public Local obtener(int idLocal) throws DAOExcepcion {
		Local vo = new Local();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select local_id, nombre, direccion, estado from local where local_id=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idLocal);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setLocal_id(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setDireccion(rs.getString(3));
				vo.setEstado(rs.getString(4));
				//vo.setSalas(salas);
				//vo.setInstrumentos(instrumentos);
				//vo.setServicios(servicios);
			}
			
			
			// -- cargar lista de servicios 
			Collection<Servicio> servicios = new ArrayList<Servicio>();
			query = "select servicio_id, descripcion, precio_hora, estado from servicio where local_id=?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idLocal);
			rs = stmt.executeQuery();
			
			while (rs.next()){
				Servicio se = new Servicio();
				se.setServicio_id(rs.getInt(1));
				se.setDescripcion(rs.getString(2));
				se.setPrecio_hora(rs.getDouble(3));
				se.setEstado(rs.getString(4).toCharArray()[0]);
				se.setLocal(vo);
				servicios.add(se);
				
			}
			
			// -- cargar lista de instrumentos 
			Collection<Instrumento> instrumentos = new ArrayList<Instrumento>();
			query = "select instrumento_id, tipo, caracteristicas, local_id, marca, modelo, precio, estado from instrumento where local_id=?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idLocal);
			rs = stmt.executeQuery();
			
			while (rs.next()){
				Instrumento in = new Instrumento();
				in.setInstrumento_id(rs.getInt(1));
				in.setTipo(rs.getString(2));
				in.setCaracteristicas(rs.getString(3));
				in.setLocal(vo);
				in.setMarca(rs.getString(5));
				in.setModelo(rs.getString(6));
				in.setPrecio(rs.getDouble(7));
				in.setEstado(rs.getString(8).toCharArray()[0]);
				instrumentos.add(in);
				
			}			

			// -- cargar lista de salas 
			Collection<Sala> salas = new ArrayList<Sala>();
			query = "select sala_id, nombre, capacidad, caracteristicas, costo, local_id, estado from sala where local_id=?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idLocal);
			rs = stmt.executeQuery();
			
			while (rs.next()){
				Sala sa = new Sala();
				sa.setSalaId(rs.getInt(1));
				sa.setNombre(rs.getString(2));
				sa.setCapacidad(rs.getInt(3));
				sa.setCaracteristicas(rs.getString(4));
				sa.setCosto(rs.getDouble(5));
				sa.setLocal(vo);
				sa.setEstado(rs.getString(7));
				salas.add(sa);
			}
			
			vo.setServicios(servicios);
			vo.setInstrumentos(instrumentos);
			vo.setSalas(salas);
			
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

/*	public void eliminar(int idLocal) throws DAOExcepcion {
		String query = "delete from local WHERE local_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idLocal);
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
	}*/

	public void eliminar(int idLocal) throws DAOExcepcion {
		String query = "update local set estado=? where local_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "0");
			stmt.setInt(2, idLocal);
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
	
	public Local actualizar(Local vo) throws DAOExcepcion {
		String query = "update local set nombre=?,direccion=? where local_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDireccion());
			stmt.setInt(3, vo.getLocal_id());
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

	public Collection<Local> listar() throws DAOExcepcion {
		Collection<Local> c = new ArrayList<Local>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select local_id, nombre, direccion, estado from local order by nombre";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Local vo = new Local();
				vo.setLocal_id(rs.getInt("local_id"));
				vo.setNombre(rs.getString("nombre"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setEstado(rs.getString("estado"));
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
