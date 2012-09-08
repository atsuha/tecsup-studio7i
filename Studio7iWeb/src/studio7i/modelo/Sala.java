package studio7i.modelo;

import java.util.Collection;

public class Sala {
	private String nombre;
	private double capacidad;
	private String caracteristicas;
	private double costo;
	private Collection<Local> local;
	
	public Sala() {
		
	}	
	
	public Sala(String nombre, double capacidad, String caracteristicas, double costo, Collection<Local> local) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.caracteristicas = caracteristicas;
		this.costo = costo;
		this.local = local;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
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

	public Collection<Local> getLocal() {
		return local;
	}

	public void setLocal(Collection<Local> local) {
		this.local = local;
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
