package studio7i.modelo;

import java.util.Collection;

public class Servicio {
	private int servicio_id;
	private String descripcion;
	private double precio_hora;
	private Local local;
	
	
	public Servicio(){}


	public Servicio(int servicio_id, String descripcion, double precio_hora,
			Local local) {
		super();
		this.servicio_id = servicio_id;
		this.descripcion = descripcion;
		this.precio_hora = precio_hora;
		this.local = local;
	}


	public int getServicio_id() {
		return servicio_id;
	}


	public void setServicio_id(int servicio_id) {
		this.servicio_id = servicio_id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio_hora() {
		return precio_hora;
	}


	public void setPrecio_hora(double precio_hora) {
		this.precio_hora = precio_hora;
	}


	public Local getLocal() {
		return local;
	}


	public void setLocal(Local local) {
		this.local = local;
	}
	
	
	
	
	
	
	

}
