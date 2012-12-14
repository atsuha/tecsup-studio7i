package Studio7iJSF.beans;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import Studio7iJSF.modelo.Persona;
import Studio7iJSF.servicio.AplicacionService;

@ManagedBean(name = "personasBean")
@RequestScoped  
public class PersonaBean {

	private Collection<Persona> personas; 
       	
       	public Collection<Persona> getPersona() {
        		return personas;
        	}


        public void setPersonas(Collection<Persona> personas) {
        		this.personas = personas;
        	}


        	@Autowired
        private AplicacionService aplicacionService;
        		
        public void setAplicacionService(AplicacionService aplicacionService) {
        		this.aplicacionService = aplicacionService;
        	}


        public String listar() {
        		System.out.println("Dentro de listar()...");
        		try {
        			personas = aplicacionService.listarPersonas();
        			System.out.println("Total de usuarios: " + personas.size());
        			
        			//ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        			//HttpServletRequest request = (HttpServletRequest)context.getRequest();
//        			request.setAttribute("usuarios", usuarios);
        			
        		//	HttpSession session = (HttpSession) context.getSession(true);
        			session.setAttribute("PERSONAS_ENCONTRADAS", personas);
        			
        			
        		} catch (DAOExcepcion e) {
        			System.out.println(e.getMessage());
        		}
        		
        		return "index";
        	}
        
        
        
        public List<Persona> buscar(String consulta) {
                System.out.println(consulta);
                // Lógica de filtro

                List<Persona> encontrados = new ArrayList<Persona>();
                for (Persona p : this.personas) {
                        if (p.getApePaterno().toUpperCase()
                                        .startsWith(consulta.toUpperCase())) {
                                encontrados.add(p);
                        }
                }

                return encontrados;
        }

        public String grabar(){
                System.out.println("Seleccionado: " + codPersonaSeleccionado);
                return "autocompletar";
        }

        public String getCodPersonaSeleccionado() {
                return codPersonaSeleccionado;
        }

        public void setCodPersonaSeleccionado(String codPersonaSeleccionado) {
                this.codPersonaSeleccionado = codPersonaSeleccionado;
        }
        
    	public void elegido(SelectEvent event){
    		Object item = event.getObject();
    		System.out.println("Listener: " + item);
    	}

        
        
        
}
