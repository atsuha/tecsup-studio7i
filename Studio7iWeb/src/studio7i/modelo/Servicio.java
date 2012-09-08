package studio7i.modelo;

import java.util.Collection;

public class Servicio {
	private String descripicon;
	private double costoHora;
	private Collection<Local> locales;
	private Collection<ArmadoBasico> armadoBasicos;
	private Collection<Reserva> reservas;
	
	
	public Servicio(){
		
	}


	public Servicio(String descripicon, double costoHora,
			Collection<Local> locales, Collection<ArmadoBasico> armadoBasicos,
			Collection<Reserva> reservas) {
		super();
		this.descripicon = descripicon;
		this.costoHora = costoHora;
		this.locales = locales;
		this.armadoBasicos = armadoBasicos;
		this.reservas = reservas;
	}


	public String getDescripicon() {
		return descripicon;
	}


	public void setDescripicon(String descripicon) {
		this.descripicon = descripicon;
	}


	public double getCostoHora() {
		return costoHora;
	}


	public void setCostoHora(double costoHora) {
		this.costoHora = costoHora;
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
