package studio7i.test;

import junit.framework.Assert;
import org.junit.Test;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Reserva;
import studio7i.negocio.GestionReserva;

public class GestionReservaTest {

	@Test
	public void insertarTest() {

		GestionReserva negocio = new GestionReserva();

		try {			
			
			negocio.insertar("23-12-2012", 1, 12, 14);
			
			Reserva nuevo = negocio.obtener(6);

			Assert.assertEquals("Bateria Electrica 3", nuevo.getAlquilado());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

}
