package studio7i.modelo;

import java.util.Collection;

public class Local {
	private int local_id;	
	private String nombre;
	private String direccion;	
	private Collection<Sala> salas;
	private Collection<Instrumento> instrumentos;
	private Collection<Servicio> servicios;
	
	
	public Local(){
		
	}

	



	public Local(int local_id, String nombre, String direccion,
			Collection<Sala> salas, Collection<Instrumento> instrumentos,
			Collection<Servicio> servicios) {
		super();
		this.local_id = local_id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.salas = salas;
		this.instrumentos = instrumentos;
		this.servicios = servicios;
	}





	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Servicio> getServicios() {
		return servicios;
	}


	public void setServicios(Collection<Servicio> servicios) {
		this.servicios = servicios;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	

	public int getLocal_id() {
		return local_id;
	}





	public void setLocal_id(int local_id) {
		this.local_id = local_id;
	}





	public Collection<Sala> getSalas() {
		return salas;
	}

	public void setSalas(Collection<Sala> salas) {
		this.salas = salas;
	}

	public Collection<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(Collection<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}
	
	
	
	
	
	

	
	
	

}
