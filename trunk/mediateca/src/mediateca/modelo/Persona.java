package mediateca.modelo;

public  abstract class Persona {
	private String nombres;
	private String paterno;
	private String materno;
	//1.- Generar el constructor vacio	
	public Persona(){
		
	}
	//2.-Generar el constructor con paramteros
	//Click derecho >source>generar constructor using fields
	public Persona(String nombres, String paterno, String materno) {
		//super() llama al constructor de la clase padre (clase object)
		super();
		this.nombres = nombres;
		this.paterno = paterno;
		this.materno = materno;
	}
	
		
	//3.-Generar Get Set	
	//Click derecho >source>generar getter and setters
	
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
	
}
