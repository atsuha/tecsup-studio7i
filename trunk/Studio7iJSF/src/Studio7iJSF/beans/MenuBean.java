package Studio7iJSF.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "menuBean")
@SessionScoped
public class MenuBean {



	public String armarSalaEnsayo() {
		return "armarSalaEnsayo";  // armarSalaEnsayo.xhtml
	}

	public String buscarSalaEnsayo() {
		return "buscarSalaEnsayo";  // buscarSalaEnsayo.xhtml
	}

	public String consultarReservas() {
		return "consultarReservas";  
	}
	
	public String eventosMusicales() {
		return "eventosMusicales";  
	}
	
	public String inscribirAEvento() {
		return "inscribirAEvento";  
	}
	
	public String inscribirSalasEnsayo() {
		return "inscribirSalasEnsayo";  
	}
	
	public String registrarInstrumentos() {
		return "registrarInstrumentos";  
	}
	
	public String registrarServicios() {
		return "registrarServicios";  
	}
	
	public String registroCliente() {
		return "registroCliente";  
	}
	
	public String reservarSalaEnsayo() {
		return "reservarSalaEnsayo";  
	}
	
	public String salir() {
		return "login";  // login.xhtml
	}
}
