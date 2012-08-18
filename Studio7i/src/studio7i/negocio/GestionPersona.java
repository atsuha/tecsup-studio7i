package studio7i.negocio;

import studio7i.modelo.Persona;

public class GestionPersona {
	
	public void registrarPersona(String nombres, String paterno){
		
		Persona p = new Persona();
		
		p.setNombres(nombres);
		p.setPaterno(paterno);
		
		// logica de validacion
		
	}
	
	public void previsualizarDatos(String nombre, String paterno){
		
	}

}
