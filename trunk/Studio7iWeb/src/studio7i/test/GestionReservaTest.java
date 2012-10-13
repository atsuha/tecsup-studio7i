package studio7i.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import studio7i.dao.InstrumentoDAO;
import studio7i.dao.ReservaDAO;
import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Reserva;
import studio7i.modelo.ReservaInstrumento;
import studio7i.modelo.ReservaServicio;
import studio7i.negocio.GestionReserva;

public class GestionReservaTest {
	
	Date fecha= new Date();
	
	@Test
	public void buscarPorFechaYSalaTest() {

		GestionReserva negocio = new GestionReserva();

		 try{
			 Collection<Reserva> busqueda=negocio.buscarPorFechaYSala("2012-10-11", 1);
			 System.out.println(busqueda.size());
			 Assert.assertTrue(busqueda.size()> 0); 
		 }
		catch (DAOExcepcion e){
			
		Assert.fail("Falló la búsqueda: " + e.getMessage());
				
		}
	}


	//@Test
	public void insertarTest() {

		GestionReserva negocio = new GestionReserva();
		
		try {
			//Para Collection de Reserva_Instrumento
			ReservaInstrumento i1 = new ReservaInstrumento();
			InstrumentoDAO daoi = new InstrumentoDAO();
			i1.setOinstrumento(daoi.obtener(2));
			Collection<ReservaInstrumento> detInstrumento = new ArrayList<ReservaInstrumento>();
			detInstrumento.add(i1);
			
		//Para Collection de Reserva_Servicio
			ReservaServicio s1 = new ReservaServicio();
			ReservaDAO daos = new ReservaDAO();
			s1.setOreserva(daos.obtener(1));
			Collection<ReservaServicio> detServicio = new ArrayList<ReservaServicio>();
			detServicio.add(s1);

			negocio.insertar(11,fecha,12,1,1,1,detServicio,detInstrumento);
//			Reserva nuevo = negocio.obtener(2);
//			Assert.assertEquals(10, nuevo.getHora_inicio());

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

			negocio.actualizar(2,15,fecha,18,1);

			Reserva nuevo = negocio.obtener(2);

			Assert.assertEquals(2, nuevo.getReserva_id());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}

	
	
	
	//@Test
	public void eliminarTest() {

		GestionReserva negocio = new GestionReserva();

		try {

			negocio.eliminar(1);

			Reserva nuevo = negocio.obtener(1);

			Assert.assertEquals(null, nuevo.getFecha());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la eliminición: " + e.getMessage());

		}

	}


	

}
