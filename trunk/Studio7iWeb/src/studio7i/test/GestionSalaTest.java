package studio7i.test;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.junit.Test;

import studio7i.dao.InstrumentoDAO;
import studio7i.dao.ServicioDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Sala;
import studio7i.modelo.SalaInstrumento;
import studio7i.modelo.SalaServicio;
import studio7i.negocio.GestionSala;

public class GestionSalaTest {
	
	//@Test
	public void insertarTest() {

		GestionSala negocio = new GestionSala();

		try {
			
			// para el collections de SALA SERVICIO
			SalaServicio si1 = new SalaServicio();
			
			ServicioDAO daose = new ServicioDAO();
			si1.setServicio(daose.obtener(1));
			
			Collection<SalaServicio> detalles = new ArrayList<SalaServicio>();
			detalles.add(si1);
			//
			
			//para el collections de SALA INSTRUMENTO
			SalaInstrumento ss1 = new SalaInstrumento();
			
			InstrumentoDAO daoi = new InstrumentoDAO();
			ss1.setInstrumento(daoi.obtener(1));
			
			Collection<SalaInstrumento> detalles2 = new ArrayList<SalaInstrumento>();
			detalles2.add(ss1);
			
			
			negocio.insertar("sala de pruebas 48",10," caracteristicas caracteristicas ",150,1,detalles,detalles2);
			
			//Sala nuevo = negocio.obtener(48);
			//Assert.assertEquals("sala de pruebas 48", nuevo.getNombre());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}
	// @Test
	public void eliminarTest(){
		GestionSala negocio = new GestionSala();
		try {
			negocio.eliminar(4);
			Sala nuevo = negocio.obtener(4);
			Assert.assertEquals(null, nuevo.getNombre());
		} catch (Exception e) {
			Assert.fail("Falló la eliminición: " + e.getMessage());
		}
	}
	
	// @Test
	public void actualizarTest(){
		GestionSala negocio = new GestionSala();
		try {
			negocio.acutalizar(2, "HOLA", 150, "X xXXX", 150.56, 1, "0");
			Sala nuevo = negocio.obtener(2);
			Assert.assertEquals("HOLA", nuevo.getNombre());
		} catch (Exception e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}
	//@Test
	public void listarTest(){
		GestionSala negocio = new GestionSala();
		try {
			Collection<Sala> listado = negocio.lista();

			System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);
			
		} catch (Exception e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
	@Test
	public void buscarPorNombreTest(){
		GestionSala negocio = new GestionSala();
		try {
			Collection<Sala> listado = negocio.buscarPorNombre("Beatles");

			System.out.println(listado.size());
			
			for (Sala sala: listado) {
				Assert.assertTrue(sala.getNombre().equals("Beatles"));
			}
			
		} catch (Exception e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
}
