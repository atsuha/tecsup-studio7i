package studio7i.negocio;

import studio7i.dao.LocalDAO;
import studio7i.dao.SalaDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Sala;

public class GestionSala {
	
	public Sala insertar(String nombre,int capacidad,String caracteristicas,double costo,int local)throws DAOExcepcion{
		
		SalaDAO dao = new SalaDAO();
		
		Sala vo = new Sala();
		vo.setNombre(nombre);
		vo.setCapacidad(capacidad);
		vo.setCaracteristicas(caracteristicas);
		vo.setCosto(costo);
		
		LocalDAO daol = new LocalDAO();
		
		vo.setLocal(daol.obtener(local));
		
		return dao.insertar(vo);
	}
	
	public Sala obtener(int sala_id) throws DAOExcepcion {
		SalaDAO dao = new SalaDAO();
		return dao.obtener(sala_id);
	}
	
}
