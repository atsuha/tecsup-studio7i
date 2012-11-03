package studio7i.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Sala;

@Repository
public class SalaDAOImpl implements SalaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Sala validar(String idUsuario, String clave) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sala insertar(Sala vo) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}


}
