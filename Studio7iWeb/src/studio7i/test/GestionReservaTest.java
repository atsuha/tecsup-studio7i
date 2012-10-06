package studio7i.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Instrumento;
import studio7i.modelo.Reserva;
import studio7i.modelo.ReservaInstrumento;
import studio7i.negocio.GestionReserva;

public class GestionReservaTest {
	
	Date fecha= new Date();

	@Test
	public void insertarTest() {

		
		ReservaInstrumento ri = new ReservaInstrumento();
		Reserva r1 		=	new Reserva();
		Instrumento i1	=	new Instrumento();
		r1.setReserva_id(1);
		i1.setInstrumento_id(1);
	
		ri.setOreserva(r1);
		ri.setOinstrumento(i1);
		
		Collection <ReservaInstrumento> reservainstrumento = new ArrayList<ReservaInstrumento>();
				
		reservainstrumento.add(ri);

		GestionReserva negocio = new GestionReserva();
		try {
			//int hora_inicio, Date fecha, int hora_fin, int alquilado, int salaId, int persona_id
			negocio.insertar(6,fecha,12,1,1,1,reservainstrumento);
			Reserva nuevo = negocio.obtener(2);
			Assert.assertEquals(10, nuevo.getHora_inicio());

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
