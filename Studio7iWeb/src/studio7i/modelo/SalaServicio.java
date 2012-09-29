package studio7i.modelo;

public class SalaServicio {
	private Servicio servicio;
	private Sala sala;
	public SalaServicio(Servicio servicio, Sala sala) {
		super();
		this.servicio = servicio;
		this.sala = sala;
	}
	
	public SalaServicio() {
		super();
	}
	
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	
}
