package studio7i.modelo;

public class Instrumento {
	private int instrumento_id;
	private String tipo;
	private String marca;
	private String modelo;
	private String caracteristicas;
	private double precio;
	private Local local;
	private char estado;
	
	
	

	public Instrumento() {
	}



	public Instrumento(int instrumento_id, String tipo, String marca,
			String modelo, String caracteristicas, double precio, Local local,
			char estado) {
		super();
		this.instrumento_id = instrumento_id;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.caracteristicas = caracteristicas;
		this.precio = precio;
		this.local = local;
		this.estado = estado;
	}









	public int getInstrumento_id() {
		return instrumento_id;
	}




	public void setInstrumento_id(int instrumento_id) {
		this.instrumento_id = instrumento_id;
	}




	public String getTipo() {
		return tipo;
	}




	public char getEstado() {
		return estado;
	}









	public void setEstado(char estado) {
		this.estado = estado;
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




	public Local getLocal() {
		return local;
	}




	public void setLocal(Local local) {
		this.local = local;
	}
	
	
	
	
	
	
	
	

	

	






	
}
