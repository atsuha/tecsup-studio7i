package studio7i.modelo;

import java.util.Collection;

public class Instrumento {
	private String tipo;
	private String marca;
	private String modelo;
	private String caracteristicas;
	private double precio;
	private Collection<Local> locales;
	private Collection<ArmadoBasico> armadoBasicos;
	private Collection<Reserva> reservas;

	public Instrumento() {

	}

	public Instrumento(String tipo, String marca, String modelo,
			String caracteristicas, double precio, Collection<Local> locales,
			Collection<ArmadoBasico> armadoBasicos, Collection<Reserva> reservas) {
		super();
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.caracteristicas = caracteristicas;
		this.precio = precio;
		this.locales = locales;
		this.armadoBasicos = armadoBasicos;
		this.reservas = reservas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Collection<Local> getLocales() {
		return locales;
	}

	public void setLocales(Collection<Local> locales) {
		this.locales = locales;
	}

	public Collection<ArmadoBasico> getArmadoBasicos() {
		return armadoBasicos;
	}

	public void setArmadoBasicos(Collection<ArmadoBasico> armadoBasicos) {
		this.armadoBasicos = armadoBasicos;
	}

	public Collection<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Collection<Reserva> reservas) {
		this.reservas = reservas;
	}

}
