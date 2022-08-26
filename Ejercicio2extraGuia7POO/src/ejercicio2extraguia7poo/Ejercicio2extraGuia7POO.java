/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2extraguia7poo;

import Entidades.Punto;
import Servicios.PuntoServicios;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio2extraGuia7POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        PuntoServicios ps1 = new PuntoServicios();
       
        Punto p1 = ps1.crearPuntos();
        
        System.out.println(p1.toString());
        ps1.calcularDistancia(p1);
        
        
    }
    
}
