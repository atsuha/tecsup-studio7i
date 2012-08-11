package mediateca.modelo;
import java.util.Date;

public class Prestamo {
	private int codigo;
	private Date fecha;
	//Un prestamo pertenece a un solo socio
	private Socio oSocio;
	
	
	public Prestamo(){
		
	}


	public Prestamo(int codigo, Date fecha, Socio oSocio) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.oSocio = oSocio;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Socio getoSocio() {
		return oSocio;
	}


	public void setoSocio(Socio oSocio) {
		this.oSocio = oSocio;
	}
	
	
	

	
	
	

}
