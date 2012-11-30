package Studio7iJSF.modelo;

import java.util.Collection;

public class Sala {
	private String nombre;
	private int capacidad;
	private String caracteristicas;
	private double costo;
	private Local local;
	private int salaId;
	private String estado;
	
	private Collection<SalaInstrumento> listaInstrumentos;
	private Collection<SalaServicio> listaServicios;
	private Collection<Reserva> listadoReservas;
	
	public Sala() {
		
	}	
	
	public Sala(String nombre, int capacidad, String caracteristicas, double costo,Local local,int salaId) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.caracteristicas = caracteristicas;
		this.costo = costo;
		this.local = local;
		this.salaId = salaId;
	}

	public Collection<Reserva> getListadoReservas() {
		return listadoReservas;
	}

	public void setListadoReservas(Collection<Reserva> listadoReservas) {
		this.listadoReservas = listadoReservas;
	}

	public Collection<SalaInstrumento> getListaInstrumentos() {
		return listaInstrumentos;
	}

	public void setListaInstrumentos(Collection<SalaInstrumento> listaInstrumentos) {
		this.listaInstrumentos = listaInstrumentos;
	}

	public Collection<SalaServicio> getListaServicios() {
		return listaServicios;
	}

	public void setListaServicios(Collection<SalaServicio> listaServicios) {
		this.listaServicios = listaServicios;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	public int getSalaId() {
		return salaId;
	}

	public void setSalaId(int salaId) {
		this.salaId = salaId;
	}

	@Override
	public String toString() {
		return "ArmadoBasico [nombre=" + nombre + ", capacidad=" + capacidad
				+ ", caracteristicas=" + caracteristicas + ", costo=" + costo
				+ ", local=" + local + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (Double.doubleToLongBits(capacidad) != Double.doubleToLongBits(other.capacidad))
			return false;
		if (caracteristicas == null) {
			if (other.caracteristicas != null)
				return false;
		} else if (!caracteristicas.equals(other.caracteristicas))
			return false;
		if (Double.doubleToLongBits(costo) != Double.doubleToLongBits(other.costo))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
