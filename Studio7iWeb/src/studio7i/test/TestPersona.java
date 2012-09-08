package studio7i.test;

import static org.junit.Assert.*;

import org.junit.Test;

import studio7i.negocio.GestionPersona;

public class TestPersona {

	@Test
	public void registrarPersonaExitoso() {
		
		GestionPersona obj = new GestionPersona();
		
		obj.registrarPersona("Augusto", "Tsuha");
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void previsualizarDatosDeLaPersona(){
		GestionPersona obj = new GestionPersona();
		obj.previsualizarDatos("Augusto", "Tsuha");
	}

}
