package Studio7iJSF.modelo;

public class DetalleInstrumento {
	
	private Sala sala;
	private Instrumento instrumento;
	
	public DetalleInstrumento(Sala sala, Instrumento instrumento) {
		super();
		this.sala = sala;
		this.instrumento = instrumento;
	}
	
	public DetalleInstrumento() {
		super();
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Instrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	
}
