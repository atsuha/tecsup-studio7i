package studio7i.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	public Usuario validar(String idUsuario, String clave)
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
	
	@SuppressWarnings(value = "unchecked")
    public Collection<Usuario> buscarPorNombre(String nombre)
                    throws DAOExcepcion {
            System.out.println("UsuarioDAOImpl: buscarPorNombre() : " + nombre);

            String sql = "select id_usuario,clave,nombres,paterno,materno,correo,direccion,telefono,estado "
                            + " from usuario where nombres like ? ";

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
            return jdbcTemplate.query(sql, new Object[] { "%" + nombre + "%" },
                            mapper);
    }
        
        @SuppressWarnings("unchecked")
        public Usuario obtenerPorIdUsuario(String idUsuario) throws DAOExcepcion {
        System.out.println("UsuarioDAOImpl: obtenerPorIdUsuario() : "
                        + idUsuario);

        String sql = "select id_usuario,clave,nombres,paterno,materno,correo,direccion,telefono,estado from usuario where id_usuario=? and estado=?";

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
        
        return (Usuario) jdbcTemplate.queryForObject(sql, new Object[] {idUsuario, "1" }, mapper);
}
*/
public Persona insertarCliente(Persona vo) throws DAOExcepcion  {
        System.out.println("insertar Cliente");
        String query = "INSERT INTO persona (dni,nombres,paterno,materno,email,usuario,password) "
                        + "VALUES (?,?,?,?,?,?,?)";
        Object[] params = new Object[] { vo.getDni(),vo.getNombres(), vo.getPaterno(),
        							vo.getMaterno(),vo.getEmail(), vo.getUsuario(), vo.getPassword() };
        try {
                jdbcTemplate.update(query, params);
        } catch (Exception e) {
                throw new DAOExcepcion(e.getMessage());
        }
        return vo;
}
/*
public Usuario actualizar(Usuario vo) throws DAOExcepcion {
        String query = "UPDATE usuario SET clave=?, nombres=?, paterno=?, materno=?, correo=?, direccion=?,"
                        + " telefono=?, estado=? WHERE id_usuario=?";
        Object[] params = new Object[] { vo.getClave(), vo.getNombres(),
                        vo.getPaterno(), vo.getMaterno(), vo.getCorreo(),
                        vo.getDireccion(), vo.getTelefono(), vo.getEstado(),
                        vo.getIdUsuario() };
        try {
                jdbcTemplate.update(query, params);
        } catch (Exception e) {
                throw new DAOExcepcion(e.getMessage());
        }
        return vo;
}

public void eliminar(String idUsuario) throws DAOExcepcion {
        String query = "DELETE FROM usuario WHERE id_usuario=?";
        Object[] params = new Object[] { idUsuario };
        try {
                jdbcTemplate.update(query, params);
        } catch (Exception e) {
                throw new DAOExcepcion(e.getMessage());
        }
}

@SuppressWarnings(value = "unchecked")
public Collection<Usuario> listarTodos() throws DAOExcepcion {
        System.out.println("UsuarioDAOImpl: listarTodos()");
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
