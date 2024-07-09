/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.devcodebrain.evidenciajavaavanzado.persistencia;

import com.mycompany.devcodebrain.evidenciajavaavanzado.logica.IMC;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuanAntonioFloresZah
 */
public class ControladoraPersistenciaIMC {
    
    IMCJpaController IMCJpa = new IMCJpaController();
    
  public void crearIMC(IMC imc)
  {
        try {
            IMCJpa.create(imc);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistenciaIMC.class.getName()).log(Level.SEVERE, null, ex);
        }
          
   }
    
    //Operación READ
    
    public List<IMC> traerIMC(){
    
        return IMCJpa.findIMCEntities();
        
        
    }
    
    
}
