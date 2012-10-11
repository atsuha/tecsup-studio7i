package studio7i.test;

import static org.junit.Assert.*;

import java.util.Collection;

import junit.framework.Assert;
import org.junit.Test;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.modelo.Servicio;
import studio7i.negocio.GestionInstrumentos;
import studio7i.negocio.GestionServicios;

public class GestionServiciosTest {

	@Test
	public void insertarTest() {

		GestionServicios negocio = new GestionServicios();

		try {
			negocio.insertar("Alquiler de Instrumentos", 150, 1);

			Servicio nuevo = negocio.obtener(1);

			Assert.assertEquals("Alquiler de Instrumentos", nuevo.getDescripcion());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}
	
	
	//@Test
	public void actualizarTest() {

		GestionServicios negocio = new GestionServicios();
		try {

			negocio.actualizar(1,"Alquiler de Salas New", 250, 2);
			

			Servicio nuevo = negocio.obtener(1);

			Assert.assertEquals("Alquiler de Salas New", nuevo.getDescripcion());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}
	

	
	
	 //@Test 
	 public void listarTest(){
			GestionServicios negocio = new GestionServicios();
			
		 try{
			 Collection<Servicio> listado=negocio.listar();
			 System.out.println(listado.size());
		 Assert.assertTrue(listado.size()> 0); 
		 }
		catch (DAOExcepcion e){
			
		Assert.fail("Falló el listado: " + e.getMessage());
				
		}
		 	
		 
	 }
	 
	//@Test
		public void eliminarTest() {

			GestionServicios negocio = new GestionServicios();

			try {

				negocio.eliminar(1);

				Servicio nuevo = negocio.obtener(1);

				Assert.assertEquals(0, nuevo.getEstado());

			} catch (DAOExcepcion e) {

				Assert.fail("Falló la eliminición: " + e.getMessage());

			}
		}
}
