/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp;

import java.util.Scanner;
import mascotapp.entidades.Mascota;


/**
 *
 * @author jdeslarmes
 */
public class MascotAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    Scanner leer = new Scanner(System.in);    
        
    Mascota m1 = new Mascota("Fernando Chiquito", leer.next(), "Perro");
    
  
    
        System.out.println(m1.apodo+" "+m1.edad+" "+m1.tipo+" "+m1.color);

 }
}