package studio7i.modelo;

public class Evento {

	//atributos
	private int evento;
	private String nombre;
	private String descripcion;
	private String lugar;
	private String fecha;
	private String premios;
	
	//constructor personalizado
	public Evento(int evento, String nombre, String descripcion, String lugar, String fecha, String premios){
	this.evento = evento;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.lugar = lugar;
	this.fecha = fecha;
	this.premios = premios;
	}

	
	//constructor por defecto
	public Evento(){
	}


	//Getters and setters
	
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


	
}