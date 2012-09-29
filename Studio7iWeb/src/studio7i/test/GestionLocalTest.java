package studio7i.test;

import java.util.Collection;

import org.junit.Test;

import junit.framework.Assert;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Local;
import studio7i.negocio.GestionLocal;



public class GestionLocalTest {
	
	@Test
	public void insertarTest() {

		GestionLocal negocio = new GestionLocal();

		try {
			negocio.insertar("Santiago de surco", "Av. Caminos del Inca 1500");

			Local nuevo = negocio.obtener(2);

			Assert.assertEquals("Av. Caminos del Inca 1500", nuevo.getDireccion());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}
	
	//@Test
	public void actualizarTest() {

		GestionLocal negocio = new GestionLocal();

		try {

			negocio.actualizar(1, "Santiago de surco", "Av. Caminos del Inca 1500");

			Local nuevo = negocio.obtener(1);

			Assert.assertEquals("Av. Caminos del Inca 1500", nuevo.getDireccion());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}	
	//@Test
	public void listarTest() {

		GestionLocal negocio = new GestionLocal();

		try {
			Collection<Local> listado = negocio.listar();

			System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Falló el listado: " + e.getMessage());

		}

	}

	//@Test
	public void eliminarTest() {

		GestionLocal negocio = new GestionLocal();

		try {

			negocio.eliminar(3);

			Local nuevo = negocio.obtener(3);

			Assert.assertEquals(null, nuevo.getDireccion());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la eliminición: " + e.getMessage());

		}

	}
}
