/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Cancion;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class CancionServicios {
    
    Scanner leer = new Scanner(System.in);
    Cancion c1 = new Cancion();
    
    public Cancion crearCancion(){
        
        System.out.println("Ingrese título de la cancion: ");
        c1.setTitulo(leer.next());
        System.out.println("Ingrese título de la cancion: ");
        c1.setTitulo(leer.next());
        return c1;
    }
    
}
