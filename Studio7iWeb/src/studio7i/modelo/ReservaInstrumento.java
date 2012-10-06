package studio7i.modelo;

public class ReservaInstrumento {
	
	
	
	private Instrumento oinstrumento;
	private Reserva 	oreserva;
	private String		estado;
	
	public ReservaInstrumento (){
		
	}

	public ReservaInstrumento(Instrumento oinstrumento, Reserva oreserva,
			String estado) {
		super();
		this.oinstrumento = oinstrumento;
		this.oreserva = oreserva;
		this.estado = estado;
	}

	public Instrumento getOinstrumento() {
		return oinstrumento;
	}

	public void setOinstrumento(Instrumento oinstrumento) {
		this.oinstrumento = oinstrumento;
	}

	public Reserva getOreserva() {
		return oreserva;
	}

	public void setOreserva(Reserva oreserva) {
		this.oreserva = oreserva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
	
	
}
