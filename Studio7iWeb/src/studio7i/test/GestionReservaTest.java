package studio7i.test;

import java.util.Collection;

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
			negocio.insertar(10, "2012-09-27",15,1);

			Reserva nuevo = negocio.obtener(7);

			Assert.assertEquals("2012-09-27", nuevo.getFecha());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	//@Test 
		 public void listarTest(){
			 GestionReserva negocio=new GestionReserva();		 
			 try{
				 Collection<Reserva> listado=negocio.listar();
				 System.out.println(listado.size());
			 Assert.assertTrue(listado.size()> 0); 
			 }
			catch (DAOExcepcion e){
				
			Assert.fail("Falló el listado: " + e.getMessage());
					
			}
			 
		 }
	 
	
	//@Test
	public void actualizarTest() {

		GestionReserva negocio = new GestionReserva();

		try {

			negocio.actualizar(2,15,"2012-09-26",18,1);

			Reserva nuevo = negocio.obtener(2);

			Assert.assertEquals("2012-09-26", nuevo.getFecha());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}

	
	
	
	//@Test
	public void eliminarTest() {

		GestionReserva negocio = new GestionReserva();

		try {

			negocio.eliminar(4);

			Reserva nuevo = negocio.obtener(4);

			Assert.assertEquals(null, nuevo.getFecha());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la eliminición: " + e.getMessage());

		}

	}


	

}
