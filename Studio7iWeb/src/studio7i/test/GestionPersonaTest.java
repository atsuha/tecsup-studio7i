package studio7i.test;

import java.util.Collection;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Persona;
import studio7i.negocio.GestionPersona;

public class GestionPersonaTest {

	//  @Test
	public void insertarTest() {

		GestionPersona negocio = new GestionPersona();

		try {
			
			Date fecha = new Date( );
			negocio.insertar("10323744", "Augusto", "Tsuha", "Tamanaha", "augusto.tsuha@gmail.com", fecha, "atsuha", "1234", "1");

			Persona nuevo = negocio.obtener(1);

			Assert.assertEquals("10323744", nuevo.getDni());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}
	
	// @Test
	public void actualizarTest() {

		GestionPersona negocio = new GestionPersona();

		try {

			Date fecha = new Date( );
			
			negocio.actualizar(1, "10323744", "Augusto", "Tsuha", "Tamanaha", "augusto.tsuha@gmail.com", fecha, "atsuha", "1234", "1");

			Persona nuevo = negocio.obtener(1);

			Assert.assertEquals("10323744", nuevo.getDni());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}
	
	// @Test
	public void listarTest() {

		GestionPersona negocio = new GestionPersona();

		try {
			Collection<Persona> listado = negocio.listar();

			System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Falló el listado: " + e.getMessage());

		}

	}

	// @Test
	public void eliminarTest() {

		GestionPersona negocio = new GestionPersona();

		try {

			negocio.eliminar(1);

			Persona nuevo = negocio.obtener(1);

			Assert.assertEquals("0", nuevo.getEstado());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la eliminición: " + e.getMessage());

		}

	}
	
	@Test
	public void obtenerTest(){
		
		
		GestionPersona negocio = new GestionPersona();
		
		try {

			Persona nuevo = negocio.obtener(1);
			
			Assert.assertEquals("10323744", nuevo.getDni());
			
			// Assert.assertTrue(nuevo.getServicios().size()>0);

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

}
