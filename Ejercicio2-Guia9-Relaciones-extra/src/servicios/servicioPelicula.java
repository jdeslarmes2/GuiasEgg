/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Pelicula;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class servicioPelicula {
    
    Scanner leer = new Scanner(System.in);
    
    Pelicula p1 = new Pelicula();
    
    public Pelicula crearPelicula(){
        
        System.out.println("Ingrese el nombre de la película: ");
        p1.setTitulo(leer.next());
        System.out.println("Ingrese la edad mínima para ver la película: ");
        p1.setEdadMinima(leer.nextInt());
        System.out.println("Ingrese la duración de la película en hrs.min: ");
        p1.setDuracion(leer.nextDouble());
        System.out.println("Ingrese el director de la película");
        p1.setTitulo(leer.next());
        
        return p1;
    }
    
    
}
