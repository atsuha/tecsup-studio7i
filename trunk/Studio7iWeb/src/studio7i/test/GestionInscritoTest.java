package studio7i.test;

import junit.framework.Assert;

import org.junit.Test;

import studio7i.excepcion.DAOExcepcion;
import studio7i.negocio.GestionInscrito;

public class GestionInscritoTest {

	@Test
	public void insertarTest(){
		GestionInscrito negocio = new GestionInscrito();
		try{
			negocio.insertar(1, 1, "2012-11-11", "Presentando nuestra banda");
			
	
		}catch (DAOExcepcion e){
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	
}
