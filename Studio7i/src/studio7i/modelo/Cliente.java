package studio7i.modelo;

import java.util.Collection;

public class Cliente extends Persona {

	private String codCliente;
	
	private Collection <Reserva> reservas;

	
	public Cliente(){
		
	}

	public Cliente(String codCliente, Collection<Reserva> reserva) {
		super();
		this.codCliente = codCliente;
		this.reservas = reserva;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public Collection<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Collection<Reserva> reservas) {
		this.reservas = reservas;
	}
	
		
	
}
