package studio7i.modelo;

public class Persona {

	private int persona_id;
	private String usuario;
	private String password;
	private String dni;
	private String nombres;
	private String paterno;
	private String materno;
	private String fechaNacimiento;
	private String email;
	private String rol;
	private String estado;

	
	
	// Constructores



	public Persona() {

	}

	public Persona(String usuario, String password, String dni, String nombres,
			String paterno, String materno, String fechaNacimiento, String email) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.dni = dni;
		this.nombres = nombres;
		this.paterno = paterno;
		this.materno = materno;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}
	
	
	// Getters and Setters
	
	public int getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(int persona_id) {
		this.persona_id = persona_id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

	

}
