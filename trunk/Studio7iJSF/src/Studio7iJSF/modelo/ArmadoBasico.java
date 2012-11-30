package Studio7iJSF.modelo;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArmadoBasico other = (ArmadoBasico) obj;
		if (instrumento == null) {
			if (other.instrumento != null)
				return false;
		} else if (!instrumento.equals(other.instrumento))
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		if (servicio == null) {
			if (other.servicio != null)
				return false;
		} else if (!servicio.equals(other.servicio))
			return false;
		return true;
	}
	
}
