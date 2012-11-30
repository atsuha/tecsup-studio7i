package Studio7iJSF.modelo;

public class DetalleServicio {
	private Servicio servicio;
	private Sala sala;
	public DetalleServicio(Servicio servicio, Sala sala) {
		super();
		this.servicio = servicio;
		this.sala = sala;
	}
	
	public DetalleServicio() {
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
