
package com.mycompany.devcodebrain.evidenciajavaavanzado.logica;

import com.mycompany.devcodebrain.evidenciajavaavanzado.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    
    public void crearPersona (Persona per){
    
        
        controlPersis.crearPersona(per);
    }
    
    public List<Persona>traePersonas(){
        
        return controlPersis.traerPersonas();

     }
    
    public Persona findByUsernameAndPassword(String username, String password)
    {
    
        return controlPersis.findByUsernameAndPassword(username,password);
    }
    
    public Persona findPersona(int Id)
    {
     return controlPersis.findPersona(Id);
    }
}
