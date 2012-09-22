package studio7i.test;

import junit.framework.Assert;

import org.junit.Test;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Sala;
import studio7i.negocio.GestionSala;

public class GestionSalaTest {
	@Test
	public void insertarTest() {

		GestionSala negocio = new GestionSala();

		try {
			negocio.insertar("sala1",10," caracteristicas caracteristicas ",150.5,1);

			Sala nuevo = negocio.obtener(4);

			Assert.assertEquals(10, nuevo.getCapacidad());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}
}
