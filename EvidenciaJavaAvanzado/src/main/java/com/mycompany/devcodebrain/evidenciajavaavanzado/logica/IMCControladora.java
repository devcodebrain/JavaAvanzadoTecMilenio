
package com.mycompany.devcodebrain.evidenciajavaavanzado.logica;

import com.mycompany.devcodebrain.evidenciajavaavanzado.persistencia.ControladoraPersistenciaIMC;
import java.util.List;

/**
 *
 * @author JuanAntonioFloresZah
 */
public class IMCControladora {
    ControladoraPersistenciaIMC controlPersis = new ControladoraPersistenciaIMC();
    
   public void crearIMC (IMC imc){
    
        
        controlPersis.crearIMC(imc);
    }
    
    public List<IMC>traeIMC(){
        
        return controlPersis.traerIMC();

     }
       
}
