package studio7i.modelo;




public class Inscrito {

	//atributos
	private Evento evento;
	private Persona persona;
	private String fecha;
	private String presentacion;	
	
	public Inscrito(){
		
	}

	//constructor con parametros
	public Inscrito(Evento evento, Persona persona, String fecha,
			String presentacion) {
		super();
		this.evento = evento;
		this.persona = persona;
		this.fecha = fecha;
		this.presentacion = presentacion;
	}
	
	//getters and setters

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	
}
