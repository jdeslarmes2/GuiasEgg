/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una frase: ");
        String frase = leer.nextLine();
        String letra = frase.substring(0,1);
        
        if (letra.equals("A")) {
        System.out.println("Correcto"); 
        }
        else {
        System.out.println("Incorrecto"); 
        }
        
    }
    
}
