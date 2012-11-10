package studio7i.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Cliente;
import studio7i.modelo.Persona;


@Repository
public class ClienteDAOImpl implements ClienteDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
/*
	public Persona validar(String idPersona, String clave)
			throws LoginExcepcion, DAOExcepcion {

		System.out.println("UsuarioDAOImpl: validar(): " + idUsuario
				+ ", clave: " + clave);

		String query = "select id_usuario,clave,nombres,paterno,materno,correo,direccion,telefono,estado from usuario where id_usuario=? and clave=?";

		ParameterizedRowMapper<Usuario> mapper = new ParameterizedRowMapper<Usuario>() {

			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				Usuario vo = new Usuario();
				vo.setIdUsuario(rs.getString("id_usuario"));
				vo.setClave(rs.getString("clave"));
				vo.setNombres(rs.getString("nombres"));
				vo.setPaterno(rs.getString("paterno"));
				vo.setMaterno(rs.getString("materno"));
				vo.setCorreo(rs.getString("correo"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setTelefono(rs.getString("telefono"));
				vo.setEstado(rs.getString("estado"));
				return vo;
			}
		};
		try {
			return (Usuario) jdbcTemplate.queryForObject(query, new Object[] {
					idUsuario, clave }, mapper);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Usuario y/o clave incorrecto");
			throw new LoginExcepcion();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}

	}
	*/
	@SuppressWarnings(value = "unchecked")
    public Collection<Cliente> buscarPorNombre(String nombre)
                    throws DAOExcepcion {
            System.out.println("ClienteDAOImpl: buscarPorNombre() : " + nombre);

            String sql = "select persona_id,nombres,paterno,materno,email,fecha_nacimiento,dni,usuario "
                            + " from persona where nombres like ? ";

            RowMapper mapper = new RowMapper() {

                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Persona vo = new Persona();
                            vo.setPersona_id(rs.getInt("persona_id"));
                            vo.setNombres(rs.getString("nombres"));
                            vo.setPaterno(rs.getString("paterno"));
                            vo.setMaterno(rs.getString("materno"));
                            vo.setEmail(rs.getString("email"));
                            vo.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                            vo.setDni(rs.getString("dni"));
                            vo.setUsuario(rs.getString("usuario"));
                             return vo;
                    }
            };
            return jdbcTemplate.query(sql, new Object[] { "%" + nombre + "%" },
                            mapper);
    }
        
        @SuppressWarnings("unchecked")
        public Cliente obtenerPorIdCliente(String idCliente) throws DAOExcepcion {
        System.out.println("ClienteDAOImpl: obtenerPorIdCliente() : "
                        + idCliente);

        String sql = "select persona_id,nombres,paterno,materno,email,fecha_nacimiento,dni,usuario  where persona_id=? and estado=?";

        RowMapper mapper = new RowMapper() {

                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Persona vo = new Persona();
                        vo.setPersona_id(rs.getInt("persona_id"));
                        vo.setNombres(rs.getString("nombres"));
                        vo.setPaterno(rs.getString("paterno"));
                        vo.setMaterno(rs.getString("materno"));
                        vo.setEmail(rs.getString("email"));
                        vo.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                        vo.setDni(rs.getString("dni"));
                        vo.setUsuario(rs.getString("usuario"));
                        return vo;
                }
        };
        
        return (Cliente) jdbcTemplate.queryForObject(sql, new Object[] {idCliente, "1" }, mapper);
}

public Persona insertarCliente(Persona vo) throws DAOExcepcion  {
        System.out.println("insertar Cliente");
        String query = "INSERT INTO persona (dni,nombres,paterno,materno,email,fecha_nacimiento,usuario,password) "
                        + "VALUES (?,?,?,?,?,?,?,?)";
        Object[] params = new Object[] { vo.getDni(),vo.getNombres(), vo.getPaterno(),
        							vo.getMaterno(),vo.getEmail(),vo.getFechaNacimiento(), vo.getUsuario(), vo.getPassword() };
        try {
                jdbcTemplate.update(query, params);
        } catch (Exception e) {
                throw new DAOExcepcion(e.getMessage());
        }
        return vo;
}

public Persona actualizar(Persona vo) throws DAOExcepcion {
        String query = "UPDATE persona SET password=?, nombres=?, paterno=?, materno=?, email=?, fecha_nacimiento=?,"
                        + " dni=? WHERE persona_id=?";
        Object[] params = new Object[] { vo.getPassword(), vo.getNombres(), vo.getPaterno(), vo.getMaterno(),
        					vo.getEmail(),vo.getFechaNacimiento(),vo.getDni() };
        try {
                jdbcTemplate.update(query, params);
        } catch (Exception e) {
                throw new DAOExcepcion(e.getMessage());
        }
        return vo;
}

public void eliminar(String idPersona) throws DAOExcepcion {
        String query = "DELETE FROM persona WHERE persona_id=?";
        Object[] params = new Object[] { idPersona };
        try {
                jdbcTemplate.update(query, params);
        } catch (Exception e) {
                throw new DAOExcepcion(e.getMessage());
        }
}
/*
@SuppressWarnings(value = "unchecked")
public Collection<Persona> listarTodos() throws DAOExcepcion {
        System.out.println("ClienteDAOImpl: listarTodos()");
        String sql = "select id_usuario,clave,nombres,paterno,materno,correo,direccion,telefono,estado from usuario ";

        RowMapper mapper = new RowMapper() {
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Usuario vo = new Usuario();
                        vo.setIdUsuario(rs.getString("id_usuario"));
                        vo.setClave(rs.getString("clave"));
                        vo.setNombres(rs.getString("nombres"));
                        vo.setPaterno(rs.getString("paterno"));
                        vo.setMaterno(rs.getString("materno"));
                        vo.setCorreo(rs.getString("correo"));
                        vo.setDireccion(rs.getString("direccion"));
                        vo.setTelefono(rs.getString("telefono"));
                        vo.setEstado(rs.getString("estado"));
                        return vo;
                }
        };
        return jdbcTemplate.query(sql, mapper);
}

public void agregarRol(Usuario uvo, Rol rvo) throws DAOExcepcion {
        
        String query = "INSERT INTO usuario_rol (rol_nombre, id_usuario) "
                        + "VALUES (?, ?)";
        Object[] params = new Object[] { rvo.getRolNombre(), uvo.getIdUsuario() };
        try {
                jdbcTemplate.update(query, params);
        } catch (Exception e) {
                throw new DAOExcepcion(e.getMessage());
        }
}*/

}
