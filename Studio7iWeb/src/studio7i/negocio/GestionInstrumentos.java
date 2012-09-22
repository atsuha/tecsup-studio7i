package studio7i.negocio;

import studio7i.dao.InstrumentoDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;

public class GestionInstrumentos {

	public Instrumento insertar(String tipo, String marca,String modelo,String caracteristicas,double precio)
			throws DAOExcepcion {
		
		InstrumentoDAO dao = new InstrumentoDAO();

		Instrumento vo = new Instrumento();
		
		vo.setTipo(tipo);
		vo.setModelo(modelo);
		vo.setMarca(marca);
		vo.setCaracteristicas(caracteristicas);
		vo.setPrecio(precio);	
		
		return dao.insertar(vo);				
	}

	public Instrumento obtener(int instrumento_id) throws DAOExcepcion {
		InstrumentoDAO dao = new InstrumentoDAO();
		return dao.obtener(instrumento_id);
	}

}
