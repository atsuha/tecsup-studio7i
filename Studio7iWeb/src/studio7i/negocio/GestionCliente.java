package studio7i.negocio;

import studio7i.modelo.Persona;

public class GestionCliente {
	
	public void RegistrarCliente(int id, String usuario, String clave, String dni, String nombres, String fechanacimiento, String email){
		Persona ClienteNuevo = new Persona();
		
		ClienteNuevo.setClave(clave);
		ClienteNuevo.setDni(dni);
		ClienteNuevo.setEmail(email);
		ClienteNuevo.setFechaNacimiento(fechanacimiento);
		
		
		
		
	}
	

}
