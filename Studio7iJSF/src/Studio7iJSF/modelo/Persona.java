package Studio7iJSF.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="persona_id")
	private int personaId;

	private String dni;

	private String email;

	private String estado;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fnac;

	private String materno;

	private String nombres;

	private String password;

	private String paterno;

	private String rol;

	private String usuario;

	//bi-directional many-to-one association to Inscrito
	@OneToMany(mappedBy="persona")
	private Set<Inscrito> inscritos;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="persona")
	private Set<Reserva> reservas;

    public Persona() {
    }

	public int getPersonaId() {
		return this.personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaNacimiento() {
		return this.fnac;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fnac = fnac;
	}

	public String getMaterno() {
		return this.materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPaterno() {
		return this.paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Set<Inscrito> getInscritos() {
		return this.inscritos;
	}

	public void setInscritos(Set<Inscrito> inscritos) {
		this.inscritos = inscritos;
	}
	
	public Set<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}
	
}