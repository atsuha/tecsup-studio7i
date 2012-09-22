package studio7i.test;

import junit.framework.Assert;

import org.junit.Test;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;
import studio7i.negocio.GestionEvento;


public class GestionEventoTest {

	@Test 
	public void InsertarTest(){
		GestionEvento evento = new GestionEvento();
		
		try{
			evento.insertar("Rock 80", "Full bandas peruanas", "Parque de la Exposicion", "07/10/1992", "1er puesto: S/.5000");
			
			Evento nuevo = evento.buscar(1);
			Assert.assertEquals("Rock 80", nuevo.getNombre());
		}catch(DAOExcepcion e){
			Assert.fail("Fallo la inserción:" + e.getMessage());
		}
	}
	
	//@Test

	
	
	
}
