/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.guia9.relaciones;

import servicios.servicioBaraja;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio3Guia9Relaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        servicioBaraja sb = new servicioBaraja();
        
        sb.crearBaraja();
        sb.barajar();
        sb.siguienteCarta();
        sb.cartasDisponibles();
        sb.darCartas();
        sb.cartasMonton();
        sb.mostrarBaraja();
        
    }
    
}
