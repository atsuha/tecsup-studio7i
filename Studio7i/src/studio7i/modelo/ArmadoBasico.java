package studio7i.modelo;

import java.util.Collection;

public class ArmadoBasico {
	
	private Collection<Sala> sala;
	private Collection<Servicio> servicio;
	private Collection<Instrumento> instrumento;
	
	public ArmadoBasico(Collection<Sala> sala, Collection<Servicio> servicio, Collection<Instrumento> instrumento) {
		this.sala = sala;
		this.servicio = servicio;
		this.instrumento = instrumento;
	}
	
	public ArmadoBasico() {
		
	}
	
	public Collection<Sala> getSala() {
		return sala;
	}
	public void setSala(Collection<Sala> sala) {
		this.sala = sala;
	}
	public Collection<Servicio> getServicio() {
		return servicio;
	}
	public void setServicio(Collection<Servicio> servicio) {
		this.servicio = servicio;
	}
	public Collection<Instrumento> getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(Collection<Instrumento> instrumento) {
		this.instrumento = instrumento;
	}
	
	
	
}
