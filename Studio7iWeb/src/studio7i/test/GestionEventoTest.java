package studio7i.test;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import studio7i.excepcion.DAOExcepcion;
import studio7i.modelo.Evento;
import studio7i.negocio.GestionEvento;


public class GestionEventoTest {

	//@Test 
	public void InsertarTest(){
		GestionEvento evento = new GestionEvento();
		
		try{
			evento.insertar("Rock en el parque", "bandas internacionales", "Miraflores", "2000-01-22", "1er puesto: S/.3000");
			
			Evento nuevo = evento.buscar(1);
			Assert.assertEquals("Rock en el parque", nuevo.getNombre());
		}catch(DAOExcepcion e){
			Assert.fail("Fallo la inserción:" + e.getMessage());
		}
	}
	
	//@Test
	public void eliminarTest(){
		GestionEvento evento = new GestionEvento();
		try{
			evento.eliminar(1);
			Evento nuevo = evento.buscar(1);
			
			Assert.assertEquals(null, nuevo.getDescripcion());
			
		}catch (DAOExcepcion e){
			Assert.fail("Falló la eliminación: " + e.getMessage());
		}
	}

	
	//@Test
	public void actualizarTest(){
		GestionEvento evento = new GestionEvento();
		try{
			evento.actualizar(1, "", "", "", "", "");
			
			Evento nuevo = evento.buscar(1);
			Assert.assertEquals("",nuevo.getNombre());
		} catch(DAOExcepcion e){
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}
	
	
	@Test
	public void listarTest(){
		GestionEvento negocio = new GestionEvento();
		try{
			Collection<Evento> listado = negocio.listar();
			
			System.out.println(listado.size());
						
			Assert.assertTrue(listado.size()>0);
			
		}catch (DAOExcepcion e){
			Assert.fail("Fallo el listado: " + e.getMessage());
		}
	}

	
	
}
