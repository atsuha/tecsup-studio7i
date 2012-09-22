package studio7i.modelo;

public class Reserva {
	private int reserva_id;
	private String fecha;
	private int hora_inicio;
	private int hora_fin;
	private int alquilado;
	private Persona oPersona;
	private Sala oSala;
	
	public Reserva(){
		
	}

	public Reserva(int reserva_id, String fecha, int hora_inicio, int hora_fin,
			int alquilado, Persona oPersona, Sala oSala) {
		super();
		this.reserva_id = reserva_id;
		this.fecha = fecha;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.alquilado = alquilado;
		this.oPersona = oPersona;
		this.oSala = oSala;
	}

	public int getReserva_id() {
		return reserva_id;
	}

	public void setReserva_id(int reserva_id) {
		this.reserva_id = reserva_id;
	}

	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public int getAlquilado() {
		return alquilado;
	}

	public void setAlquilado(int alquilado) {
		this.alquilado = alquilado;
	}

	public Persona getoPersona() {
		return oPersona;
	}

	public void setoPersona(Persona oPersona) {
		this.oPersona = oPersona;
	}

	public Sala getoSala() {
		return oSala;
	}

	public void setoSala(Sala oSala) {
		this.oSala = oSala;
	}


	


	
	
	
}
