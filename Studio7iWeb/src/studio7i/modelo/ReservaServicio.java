package studio7i.modelo;

public class ReservaServicio {

	private Servicio oservicio;
	private Reserva oreserva;
	
	public ReservaServicio(){
		
	}
	
	public ReservaServicio(Servicio oservicio, Reserva oreserva) {
		super();
		this.oservicio = oservicio;
		this.oreserva = oreserva;
	}

	public Servicio getOservicio() {
		return oservicio;
	}

	public void setOservicio(Servicio oservicio) {
		this.oservicio = oservicio;
	}

	public Reserva getOreserva() {
		return oreserva;
	}

	public void setOreserva(Reserva oreserva) {
		this.oreserva = oreserva;
	}
	
	

	
	
}
