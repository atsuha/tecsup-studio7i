package studio7i.modelo;

public class ReservaInstrumento {
	
	private Instrumento oinstrumento;
	private Reserva oreserva;
	
	public ReservaInstrumento (){
		
	}

	public ReservaInstrumento(Instrumento oinstrumento, Reserva oreserva) {
		super();
		this.oinstrumento = oinstrumento;
		this.oreserva = oreserva;
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

	
	
	
	
	
}
