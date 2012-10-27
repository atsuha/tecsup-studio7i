package studio7i.modelo;

import java.util.Collection;

public class Evento {

	//atributos
	private int evento_id;
	private String nombre;
	private String descripcion;
	private String lugar;
	private String fecha;
	private String premios;
	private Collection<Inscrito> inscrito;
	private char estado;

	
	//constructor sin parametros
	public Evento() {
	
	}


	//constructor con parametros
	public Evento(int evento_id, String nombre, String descripcion,
			String lugar, String fecha, String premios,
			Collection<Inscrito> inscrito, char estado) {
		super();
		this.evento_id = evento_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.fecha = fecha;
		this.premios = premios;
		this.inscrito = inscrito;
		this.estado = estado;
	}


	//getters and setters

	public int getEvento_id() {
		return evento_id;
	}


	public void setEvento_id(int evento_id) {
		this.evento_id = evento_id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getPremios() {
		return premios;
	}


	public void setPremios(String premios) {
		this.premios = premios;
	}


	public Collection<Inscrito> getInscrito() {
		return inscrito;
	}


	public void setInscrito(Collection<Inscrito> inscrito) {
		this.inscrito = inscrito;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}	
	
	
}