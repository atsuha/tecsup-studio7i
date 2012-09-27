package studio7i.modelo;

public class Reserva {

	private int 	reserva_id;
	private int 	hora_inicio;
	private int 	hora_fin;
	private String 	fecha;
	private int    	alquilado;
	public Reserva(int reserva_id, int hora_inicio, int hora_fin,
			String fecha, int alquilado) {
		super();
		this.reserva_id = reserva_id;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.fecha = fecha;
		this.alquilado = alquilado;
	}
	public Reserva() {
		// TODO Auto-generated constructor stub
	}


	public int getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(int hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public int getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(int hora_fin) {
		this.hora_fin = hora_fin;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getAlquilado() {
		return alquilado;
	}
	public void setAlquilado(int alquilado) {
		this.alquilado = alquilado;
	}
	public int getReserva_id() {
		return reserva_id;
	}
	public void setReserva_id(int reserva_id) {
		this.reserva_id = reserva_id;
	}
	
	
	
}
