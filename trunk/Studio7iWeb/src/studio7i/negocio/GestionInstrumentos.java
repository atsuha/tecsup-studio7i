package studio7i.negocio;

import java.util.Collection;

import studio7i.dao.InstrumentoDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.modelo.Local;

public class GestionInstrumentos {

	public Instrumento insertar(String tipo, String marca,String modelo,String caracteristicas,double precio,int local_id)
			throws DAOExcepcion {
		Local lo=new Local();
		lo.setLocal_id(local_id);
		
		
		InstrumentoDAO dao = new InstrumentoDAO();

		Instrumento vo = new Instrumento();
		
		vo.setTipo(tipo);
		vo.setModelo(modelo);
		vo.setMarca(marca);
		vo.setCaracteristicas(caracteristicas);
		vo.setPrecio(precio);	
		vo.setLocal(lo);
		
		
		
		return dao.insertar(vo);				
	}

	public Instrumento obtener(int instrumento_id) throws DAOExcepcion {
		InstrumentoDAO dao = new InstrumentoDAO();
		return dao.obtener(instrumento_id);
	}

	public Instrumento actualizar(int instrumento_id, String tipo, String modelo,
			String marca, String caracteristicas, double precio, int local_id)throws DAOExcepcion {
		
		Local lo=new Local();
		lo.setLocal_id(local_id);
		
		InstrumentoDAO dao =new InstrumentoDAO();
		
		Instrumento vo=new Instrumento();
		vo.setInstrumento_id(instrumento_id);
		vo.setTipo(tipo);
		vo.setModelo(modelo);
		vo.setMarca(marca);
		vo.setCaracteristicas(caracteristicas);
		vo.setPrecio(precio);	
		vo.setLocal(lo);
		return dao.actualizar(vo);	
	
	}

	public Collection<Instrumento> listar() throws DAOExcepcion {
		InstrumentoDAO dao =new InstrumentoDAO();
		return dao.listar();
	}

	public void eliminar(int instrumento_id) throws DAOExcepcion {
		InstrumentoDAO dao = new InstrumentoDAO();
		dao.eliminar(instrumento_id);
	}


}
