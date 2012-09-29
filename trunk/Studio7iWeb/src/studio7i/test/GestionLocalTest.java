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
			negocio.insertar("Surco", "Av. Caminos del Inca 1579");

			Local nuevo = negocio.obtener(1);

			Assert.assertEquals("Av. Caminos del Inca 1579", nuevo.getDireccion());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
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

}
