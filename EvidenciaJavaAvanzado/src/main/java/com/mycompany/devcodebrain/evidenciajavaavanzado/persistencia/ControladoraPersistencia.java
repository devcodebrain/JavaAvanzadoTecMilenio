
package com.mycompany.devcodebrain.evidenciajavaavanzado.persistencia;

import com.mycompany.devcodebrain.evidenciajavaavanzado.logica.Persona;
import java.util.List;

public class ControladoraPersistencia {
    
    PersonaJpaController perJpa = new PersonaJpaController();
    
    //Operacion Create
    public void crearPersona(Persona per){
        
        perJpa.create(per);
    
    }
    
    //Operación READ
    
    public List<Persona> traerPersonas(){
    
        return perJpa.findPersonaEntities();
        
        
    }
    
    public Persona findByUsernameAndPassword(String username,String password){
      return perJpa.findByUsernameAndPassword(username,password);
    
    }
    
    public Persona findPersona(int Id)
    {
       return perJpa.findPersona(Id);
    }
    
    
    
}
