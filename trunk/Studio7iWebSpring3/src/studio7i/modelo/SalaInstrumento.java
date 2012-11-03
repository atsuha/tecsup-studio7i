package studio7i.modelo;

public class SalaInstrumento {
	
	private Sala sala;
	private Instrumento instrumento;
	
	public SalaInstrumento(Sala sala, Instrumento instrumento) {
		super();
		this.sala = sala;
		this.instrumento = instrumento;
	}
	
	public SalaInstrumento() {
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
