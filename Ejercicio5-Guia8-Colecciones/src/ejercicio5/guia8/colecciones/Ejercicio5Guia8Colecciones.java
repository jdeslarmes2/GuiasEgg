/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5.guia8.colecciones;

import ejercicio5.g8.servicios.ServicioPais2;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio5Guia8Colecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        ServicioPais2 sp = new ServicioPais2();
        
        sp.crearPais();
        sp.agregarPais();
        sp.eliminarPais();
        sp.agregarPais();
        
    }
    
}
