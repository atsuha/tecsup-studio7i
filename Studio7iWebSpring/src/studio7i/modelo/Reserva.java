package studio7i.modelo;

import java.util.Date;
import java.util.Collection;
import java.text.SimpleDateFormat;


public class Reserva {

	private int 		reserva_id;
	private int 		hora_inicio;
	private int 		hora_fin;
	private Date 		fecha;
	private int    		alquilado;
	private Persona		opersona;
	private Sala		osala;
	private Collection <ReservaInstrumento> listainstrumentos;
	private Collection <ReservaServicio> listaservicios;
	
	private SimpleDateFormat d = null;
	
	
	
	
public Reserva(int reserva_id, int hora_inicio, int hora_fin, Date fecha,
			int alquilado, Persona opersona, Sala osala/*,
			Collection<ReservaInstrumento> listainstrumentos,
			Collection<ReservaServicio> listaservicios*/, SimpleDateFormat d) {
		super();
		d=new SimpleDateFormat("yyyy-MM-d:HH:mm:ss");
		this.reserva_id = reserva_id;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.fecha = fecha;
		this.alquilado = alquilado;
		this.opersona = opersona;
		this.osala = osala;/*
		this.listainstrumentos = listainstrumentos;
		this.listaservicios = listaservicios;*/
		this.d = d;
	}



	public Reserva(){
		d=new SimpleDateFormat("yyyy-MM-d:HH:mm:ss");
		
	}

	public int getReserva_id() {
		return reserva_id;
	}

	public void setReserva_id(int reserva_id) {
		this.reserva_id = reserva_id;
	}

	public int getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(int hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public int getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(int hora_fin) {
		this.hora_fin = hora_fin;
	}

	public Date getFecha() {
		return fecha;
	}
	

    public String getFechaString() {
            
            return d.format(fecha);
    }

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getAlquilado() {
		return alquilado;
	}

	public void setAlquilado(int alquilado) {
		this.alquilado = alquilado;
	}

	public Persona getOpersona() {
		return opersona;
	}

	public void setOpersona(Persona opersona) {
		this.opersona = opersona;
	}

	public Sala getOsala() {
		return osala;
	}

	public void setOsala(Sala osala) {
		this.osala = osala;
	}

//	public SimpleDateFormat getD() {
//		return d;
//	}
//
//	public void setD(SimpleDateFormat d) {
//		this.d = d;
//	}

	public Collection<ReservaInstrumento> getListainstrumentos() {
		return listainstrumentos;
	}

	public void setListainstrumentos(
			Collection<ReservaInstrumento> listainstrumentos) {
		this.listainstrumentos = listainstrumentos;
	}

	public Collection<ReservaServicio> getListaservicios() {
		return listaservicios;
	}

	public void setListaservicios(Collection<ReservaServicio> listaservicios) {
		this.listaservicios = listaservicios;
	}



}