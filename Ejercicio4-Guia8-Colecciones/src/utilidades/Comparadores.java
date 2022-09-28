/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import entidades.pelicula;
import java.util.Comparator;

/**
 *
 * @author jdeslarmes
 */
public class Comparadores {
    
    public static Comparator<pelicula> ordenarMayorMenor = new Comparator<pelicula>() {
        @Override
        public int compare(pelicula t, pelicula t1) {
         
            return t1.getDuracion().compareTo(t.getDuracion());
        }
    };
    
     public static Comparator<pelicula> ordenarMenorMayor = new Comparator<pelicula>() {
        @Override
        public int compare(pelicula t, pelicula t1) {
         
            return t.getDuracion().compareTo(t1.getDuracion());
        }
    };
         public static Comparator<pelicula> ordenarTitulo = new Comparator<pelicula>() {
        @Override
        public int compare(pelicula t, pelicula t1) {
         
            return t.getTitulo().compareTo(t1.getTitulo());
        }
    };
             public static Comparator<pelicula> ordenarDirector = new Comparator<pelicula>() {
        @Override
        public int compare(pelicula t, pelicula t1) {
         
            return t.getDirector().compareTo(t1.getDirector());
        }
    };
}
