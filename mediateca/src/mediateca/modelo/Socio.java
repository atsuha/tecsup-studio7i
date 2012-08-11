package mediateca.modelo;

import java.util.Collection;

public class Socio extends Persona {

	private String codCarnet;
	//Un socio puede realizar muchios prestamos
	private Collection<Prestamo> prestamos;
	
	public Socio(){
		
	
	}

	public Socio(String codCarnet, Collection<Prestamo> prestamos) {
		super();
		this.codCarnet = codCarnet;
		this.prestamos = prestamos;
	}

	
	
	public String getCodCarnet() {
		return codCarnet;
	}

	public void setCodCarnet(String codCarnet) {
		this.codCarnet = codCarnet;
	}

	public Collection<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Collection<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}	

	
	
	
	
	
	
}
