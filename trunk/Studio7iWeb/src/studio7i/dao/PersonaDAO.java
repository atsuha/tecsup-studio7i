package studio7i.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Persona;

import studio7i.util.ConexionBD;

public class PersonaDAO  extends BaseDAO {
	
	public Collection<Persona> buscarPorDNI(String dni)
			throws DAOExcepcion {
		String query = "select persona_id, dni, nombres, paterno, materno, email, fecha_nacimiento, usuario, password, rol, estado from local where dni like ?";
		Collection<Persona> lista = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + dni + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Persona vo = new Persona();
				vo.setPersona_id (rs.getInt("persona_id"));
				vo.setDni(rs.getString("dni"));
				vo.setNombres(rs.getString("nombres"));
				vo.setPaterno(rs.getString("paterno"));
				vo.setMaterno(rs.getString("materno"));
				vo.setEmail(rs.getString("email"));
				vo.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				vo.setUsuario(rs.getString("usuario"));
				vo.setPassword(rs.getString("password"));
				vo.setRol(rs.getString("rol"));
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

	public Persona insertar(Persona vo) throws DAOExcepcion {
		String query = "insert into persona (dni, nombres, paterno, materno, email, fecha_nacimiento, usuario, password, rol) values (?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getDni());
			stmt.setString(2, vo.getNombres());
			stmt.setString(3, vo.getPaterno());
			stmt.setString(4, vo.getMaterno());
			stmt.setString(5, vo.getEmail());
			stmt.setDate(6, (Date) vo.getFechaNacimiento());
			stmt.setString(7, vo.getUsuario());
			stmt.setString(8, vo.getPassword());
			stmt.setString(9, vo.getRol());
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
			vo.setPersona_id(id);

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

	public Persona obtener(int idPersona) throws DAOExcepcion {
		Persona vo = new Persona();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select persona_id, dni, nombres, paterno, materno, email, fecha_nacimiento, usuario, password, rol, estado from persona where persona_id=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPersona);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setPersona_id(rs.getInt(1));
				vo.setDni(rs.getString(2));
				vo.setNombres(rs.getString(3));
				vo.setPaterno(rs.getString(4));
				vo.setMaterno(rs.getString(5));
				vo.setEmail(rs.getString(6));
				vo.setFechaNacimiento(rs.getDate(7));
				vo.setUsuario(rs.getString(8));
				vo.setPassword(rs.getString(9));
				vo.setRol(rs.getString(10));
				vo.setEstado(rs.getString(11));
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

	public void eliminar(int idPersona) throws DAOExcepcion {
		String query = "update persona set estado=? where local_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "0");
			stmt.setInt(2, idPersona);
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
	
	public Persona actualizar(Persona vo) throws DAOExcepcion {
		String query = "update persona set dni=?, nombres=?, paterno=?, materno=?, email=?, fecha_nacimiento=?, usuario=?, password=?, rol=?, estado=? where persona_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getDni());
			stmt.setString(2, vo.getNombres());
			stmt.setString(3, vo.getPaterno());
			stmt.setString(4, vo.getMaterno());
			stmt.setString(5, vo.getEmail());
			stmt.setDate(6, (Date) vo.getFechaNacimiento());
			stmt.setString(7, vo.getUsuario());
			stmt.setString(8, vo.getPassword());
			stmt.setString(9, vo.getRol());
			stmt.setString(10, vo.getEstado());
			stmt.setInt(11, vo.getPersona_id());
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

	public Collection<Persona> listar() throws DAOExcepcion {
		Collection<Persona> c = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select persona_id, dni, nombres, paterno, materno, email, fecha_nacimiento, usuario, password, rol, estado from local order by nombres";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Persona vo = new Persona();
				vo.setPersona_id (rs.getInt("persona_id"));
				vo.setDni(rs.getString("dni"));
				vo.setNombres(rs.getString("nombres"));
				vo.setPaterno(rs.getString("paterno"));
				vo.setMaterno(rs.getString("materno"));
				vo.setEmail(rs.getString("email"));
				vo.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				vo.setUsuario(rs.getString("usuario"));
				vo.setPassword(rs.getString("password"));
				vo.setRol(rs.getString("rol"));
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
