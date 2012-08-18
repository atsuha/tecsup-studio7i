package studio7i.modelo;

public class Persona {
	
	private String nombres;
	private String paterno;
	private String materno;
	private String dni;
	
	public Persona (){
		
	}
	
	public Persona(String nombres, String paterno, String materno, String dni) {
		super();
		this.nombres = nombres;
		this.paterno = paterno;
		this.materno = materno;
		this.dni = dni;
	}
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

}
