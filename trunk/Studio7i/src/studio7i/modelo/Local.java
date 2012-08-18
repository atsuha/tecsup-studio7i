package studio7i.modelo;

import java.util.Collection;

public class Local {
	private String nombre;
	private String direccion;
	private String distrito;
	private Collection<Sala> salas;
	private Collection<Instrumento> instrumentos;
	private Collection<Servicio> servicios;
	
	
	public Local(){
		
	}

	
	public Local(String nombre, String direccion, String distrito,
			Collection<Sala> salas, Collection<Instrumento> instrumentos,
			Collection<Servicio> servicios) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.distrito = distrito;
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

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
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
