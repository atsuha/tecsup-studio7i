package studio7i.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.negocio.GestionInstrumentos;

public class GestionInstrumentosTest {
	
		@Test
		public void insertarTest() {

			GestionInstrumentos negocio = new GestionInstrumentos();

			try {
				negocio.insertar("Bateria Electrica 3", "Yamahasa","XZ1000","Para zurdos",500);

				Instrumento nuevo = negocio.obtener(6);

				Assert.assertEquals("Bateria Electrica 3", nuevo.getTipo());

			} catch (DAOExcepcion e) {
				Assert.fail("Fallo la inserción: " + e.getMessage());
			}
		}

	
}
