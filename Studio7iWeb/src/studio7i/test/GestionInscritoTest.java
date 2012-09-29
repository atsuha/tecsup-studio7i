package studio7i.test;

import junit.framework.Assert;

import org.junit.Test;

import studio7i.excepcion.DAOExcepcion;
import studio7i.negocio.GestionInscrito;

public class GestionInscritoTest {

	//@Test
	public void insertarTest(){
		GestionInscrito negocio = new GestionInscrito();
		try{
			negocio.insertar(2, 2, "2012-11-11", "AC/DC rocks");
			
	
		}catch (DAOExcepcion e){
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}
	
	@Test
	public void eliminarTest(){
		GestionInscrito negocio = new GestionInscrito();
		
		try{
			negocio.eliminar(1, 1);
		}catch (DAOExcepcion e){
			Assert.fail("Falló la eliminacion: " + e.getMessage());
		}
	}
	

	
}
