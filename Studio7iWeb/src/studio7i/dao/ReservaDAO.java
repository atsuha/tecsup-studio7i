package studio7i.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Persona;
import studio7i.modelo.Reserva;
import studio7i.modelo.ReservaInstrumento;
import studio7i.modelo.ReservaServicio;
import studio7i.modelo.Sala;
import studio7i.util.ConexionBD;
import studio7i.dao.BaseDAO;

public class ReservaDAO extends BaseDAO {

	public Collection<Reserva> buscarPorFechaYSala(String fecha, int sala_id)
			throws DAOExcepcion {
		String query = "select r.reserva_id, r.sala_id, r.hora_inicio, r.fecha, r.hora_fin, r.alquilado, p.nombres, p.paterno, p.materno, s.costo " +
						"from reserva r " +
						"left join persona p on (r.persona_id = p.persona_id) " +
						"left join sala s on (r.sala_id = s.sala_id) " +
						"where r.fecha = ? and r.sala_id = ?";
		Collection<Reserva> lista = new ArrayList<Reserva>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, fecha);
			stmt.setInt(2, sala_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				 Reserva vo =new Reserva();
				 vo.setReserva_id(rs.getInt("reserva_id"));
				 vo.setHora_inicio(rs.getInt("hora_inicio"));
				 vo.setHora_fin(rs.getInt("hora_fin"));
				 vo.setAlquilado(rs.getInt("alquilado"));
				 
				 Collection<ReservaInstrumento> listaInstrumentos = new ArrayList<ReservaInstrumento>();
				 ReservaInstrumentoDAO riDAO = new ReservaInstrumentoDAO();
				 listaInstrumentos = riDAO.buscarPorReserva(vo);
				 vo.setListainstrumentos(listaInstrumentos);
				 
				 Persona pe = new Persona();
				 pe.setNombres(rs.getString("nombres"));
				 pe.setPaterno(rs.getString("paterno"));
				 pe.setMaterno(rs.getString("materno"));
				 vo.setOpersona(pe);

				 Sala sa = new Sala();
				 sa.setSalaId(rs.getInt("sala_id"));
				 sa.setCosto(rs.getDouble("costo"));
				 vo.setOsala(sa);
				 
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
	
	public Reserva insertar(Reserva vo)throws DAOExcepcion { 
		String query 			= "insert into Reserva(hora_inicio, fecha, hora_fin, alquilado,persona_id,sala_id) values (?,?,?,?,?,?)";
		Connection con 			= null;
		PreparedStatement stmt 	= null;
		ResultSet rs 			= null;
	
		try {
			con 	= ConexionBD.obtenerConexion();
			stmt 	= con.prepareStatement(query);
			stmt.setInt(1, vo.getHora_inicio());
			stmt.setString(2, vo.getFechaString());
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
			
			//Creando el objeto Reserva
			ReservaDAO reserva1 		= new ReservaDAO();
			
			ReservaInstrumentoDAO daoi 	= new ReservaInstrumentoDAO();
			
			ReservaServicioDAO daos		= new ReservaServicioDAO();
			
			
			for (ReservaInstrumento inst : vo.getListainstrumentos()){
				ReservaInstrumento ri	= new ReservaInstrumento();
				ri.setOreserva(reserva1.obtener(id));
				ri.setOinstrumento(inst.getOinstrumento());
				daoi.insertar(ri, con);
							
				
			}
			
			for (ReservaServicio s1 : vo.getListaservicios()){
				ReservaServicio rs1	= new ReservaServicio();
				rs1.setOreserva(reserva1.obtener(id));
				rs1.setOservicio(s1.getOservicio());
				daos.insertar(rs1, con);
				
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
			//this.cerrarConexion(con);
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
