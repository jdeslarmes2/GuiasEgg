/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.guia9.relaciones;

import entidades.Pelicula;
import servicios.servicioCine;
import servicios.servicioEspectador;
import servicios.servicioPelicula;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio2Guia9Relaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        servicioPelicula sp = new servicioPelicula(); 
        servicioCine sc = new servicioCine();

        
        
        sc.crearCine(sp.crearPelicula());
        sc.completarSala();
        
        
        
    }
}

