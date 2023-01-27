/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.logging.Level;
import java.util.logging.Logger;
import principal.dominio.empleado.EmpleadoService;


/**
 *
 * @author jdeslarmes
 */
public class MainClass {


    public static void main(String[] args) {
      
        EmpleadoService empleadoService = new EmpleadoService();
        
        
        try{
            empleadoService.crearEmpleado(1000, "Josefita");
            
        }catch (Exception ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
