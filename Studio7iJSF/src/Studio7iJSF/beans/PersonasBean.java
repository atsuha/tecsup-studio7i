package Studio7iJSF.beans;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;

import Studio7iJSF.modelo.Persona;

@ManagedBean(name = "personasBean")
@RequestScoped  
public class PersonasBean {

        private String codPersonaSeleccionado;
        private List<Persona> personas;

        public PersonasBean() {
                personas = new ArrayList<Persona>();

                Persona p1 = new Persona();
                p1.setCodPersona("501");
                p1.setApePaterno("Rodriguez");
                p1.setApeMaterno("Condezo");
                p1.setNombres("David");
                p1.setDireccion("Lima 13");
                p1.setCorreo("rcondezo@gmail.com");

                Persona p2 = new Persona();
                p2.setCodPersona("502");
                p2.setApePaterno("Perez");
                p2.setApeMaterno("Lopez");
                p2.setNombres("Juan");
                p2.setDireccion("Lima 21");
                p2.setCorreo("jperez@gmail.com");

                Persona p3 = new Persona();
                p3.setCodPersona("503");
                p3.setApePaterno("Rodriguez");
                p3.setApeMaterno("Quispe");
                p3.setNombres("Luis");
                p3.setDireccion("Lima 3");
                p3.setCorreo("lflores@gmail.com");

                personas.add(p1);
                personas.add(p2);
                personas.add(p3);

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
