package studio7i.test;

import static org.junit.Assert.*;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.negocio.GestionInstrumentos;

public class GestionInstrumentosTest {
	
		//@Test
		public void insertarTest() {

			GestionInstrumentos negocio = new GestionInstrumentos();

			try {
				negocio.insertar("Piano", "Yamota","XZ45435","Para diestros",689,1);

				Instrumento nuevo = negocio.obtener(2);

				Assert.assertEquals("Piano", nuevo.getTipo());

			} catch (DAOExcepcion e) {
				Assert.fail("Fallo la inserción: " + e.getMessage());
			}
		}

		// @Test 
			 public void listarTest(){
				 GestionInstrumentos negocio=new GestionInstrumentos();		 
				 try{
					 Collection<Instrumento> listado=negocio.listar();
					 System.out.println(listado.size());
				 Assert.assertTrue(listado.size()> 0); 
				 }
				catch (DAOExcepcion e){
					
				Assert.fail("Falló el listado: " + e.getMessage());
						
				}
				 
			 }
		 
		
		//@Test
		public void actualizarTest() {

			GestionInstrumentos negocio = new GestionInstrumentos();

			try {

				negocio.actualizar(2,"Guitarra 2", "Yamahasa5","XZ1000","Para zurdos",500,2);

				Instrumento nuevo = negocio.obtener(2);

				Assert.assertEquals("Guitarra 2", nuevo.getTipo());

			} catch (DAOExcepcion e) {

				Assert.fail("Falló la actualización: " + e.getMessage());

			}
		}
	
		
		
		
		@Test
		public void eliminarTest() {

			GestionInstrumentos negocio = new GestionInstrumentos();

			try {

				negocio.eliminar(2);

				Instrumento nuevo = negocio.obtener(2);

				Assert.assertEquals(null, nuevo.getTipo());

			} catch (DAOExcepcion e) {

				Assert.fail("Falló la eliminición: " + e.getMessage());

			}

		}


}
