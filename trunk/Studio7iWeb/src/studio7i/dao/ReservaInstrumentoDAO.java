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
import studio7i.modelo.Reserva;
import studio7i.modelo.ReservaInstrumento;
import studio7i.util.ConexionBD;
public class ReservaInstrumentoDAO extends BaseDAO {

	
	// a este metodo se le pasa el con para poder insertar en detalle
	public ReservaInstrumento insertar (ReservaInstrumento vo, Connection con)throws DAOExcepcion{
	
		
		String query = "insert into reserva_instrumento (instrumento_id, reserva_id) values (?,?)";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1,vo.getOinstrumento().getInstrumento_id());
			stmt.setInt(2,vo.getOreserva().getReserva_id());
														
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
	
	public Collection<ReservaInstrumento> buscarPorReserva(Reserva oreserva)
			throws DAOExcepcion {
		int reserva_id = oreserva.getReserva_id();
		String query = "select ri.reserva_id, ri.instrumento_id, ri.estado, " +
				"i.tipo, i.caracteristicas, i.local_id, i.marca, i.modelo, i.precio " +
				"from reserva_instrumento ri " +
				"left join instrumento i on (ri.instrumento_id = i.instrumento_id) " +
				"where reserva_id = ? and estado";
		Collection<ReservaInstrumento> lista = new ArrayList<ReservaInstrumento>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, reserva_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ReservaInstrumento vo = new ReservaInstrumento();
				Instrumento oinstrumento = new Instrumento();
				oinstrumento.setTipo(rs.getString("tipo"));
				oinstrumento.setCaracteristicas(rs.getString("caracteristicas"));				
				Local olocal = new Local();
				olocal.setLocal_id(rs.getInt("local_id"));
				oinstrumento.setLocal(olocal);
				oinstrumento.setMarca(rs.getString("marca"));
				oinstrumento.setModelo(rs.getString("modelo"));
				oinstrumento.setPrecio(rs.getDouble("precio"));
				
				vo.setOreserva(oreserva);
				vo.setOinstrumento(oinstrumento);
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

}
