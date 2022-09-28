/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4.guia8.colecciones;

import servicios.serviciopelicula;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio4Guia8Colecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        serviciopelicula sp = new serviciopelicula();
        
        sp.cargarPelicula();
        sp.agregarPelicula();
        sp.mostrarPelicula();
        sp.mostrarMayor1();
        sp.mostrarMayorMenor();
        sp.mostrarMenorMayor();
        sp.mostrarPorTitulo();
        sp.mostrarPorDirector();

        
    }
    
}
