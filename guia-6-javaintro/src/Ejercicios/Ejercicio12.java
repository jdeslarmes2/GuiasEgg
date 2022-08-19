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
public class Ejercicio12 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int suma_c = 0;
        int suma_i =0;
        String cadena;
        
 do {
        
        System.out.println("Ingrese una cadena");
        cadena = leer.nextLine();
        
        if (cadena.length() == 5 && cadena.substring(0,1).equals("X") && cadena.substring(4,5).equals("O")) {
            suma_c++;
        
        }else {
            suma_i++;
        }
        
    } while(!"&&&&&".equals(cadena));
   if (cadena.equals("&&&&&")){
            suma_i --;
        }
            
            System.out.println("La cantidad de lecturas correctas fue de: " + suma_c);
            System.out.println("La cantidad de lecturas incorrectas fue de: " + suma_i); 
}
}
        
   