package mediateca.modelo;

public abstract class  Soporte {
	private String titulo;
	private  int  dias;
	
	
	public Soporte(){
		
	}


	public Soporte(String titulo, int dias) {
		super();
		this.titulo = titulo;
		this.dias = dias;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getDias() {
		return dias;
	}


	public void setDias(int dias) {
		this.dias = dias;
	}
	
	
	
	

}
