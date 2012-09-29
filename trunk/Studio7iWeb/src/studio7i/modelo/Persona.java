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

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
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

	
	// toString
	
	@Override
	public String toString() {
		return "Persona [usuario=" + usuario + ", password=" + password + ", dni="
				+ dni + ", nombres=" + nombres + ", paterno=" + paterno
				+ ", materno=" + materno + ", fechaNacimiento="
				+ fechaNacimiento + ", email=" + email + "]";
	}

	// equals

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (materno == null) {
			if (other.materno != null)
				return false;
		} else if (!materno.equals(other.materno))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		if (paterno == null) {
			if (other.paterno != null)
				return false;
		} else if (!paterno.equals(other.paterno))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	
	
	
	

}
