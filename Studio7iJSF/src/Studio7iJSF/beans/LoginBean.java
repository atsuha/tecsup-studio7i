package Studio7iJSF.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	
	private String usuario;
	private String clave;

	public String logear() {
		String msg = null;
		if ("user01".equals(usuario)){
			msg = "coordinador";  //coordinador.xhtml
		} else if ("user02".equals(usuario)){
			msg = "redactor";
		} else if ("user03".equals(usuario)){
			msg = "revisor";
		} else {
			msg = "olvidePassword";
		}
		
		return msg;
		 
	}
	
	public String salir(){
		// invalidar sesion, pending..!
		usuario = "";
		clave = "";
		return "login";
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	


}
