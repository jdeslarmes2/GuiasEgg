/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.util.Scanner;

/**Dado un tiempo en minutos, calcular su equivalente en días y horas. Por ejemplo, si el
usuario ingresa 1600 minutos, el sistema debe calcular su equivalente: 1 día, 2 horas.
 *
 * @author jdeslarmes
 */
public class Ejercicio1extra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               
       Scanner leer = new Scanner (System.in);
       System.out.println("Ingrese el tiempo a calcular en minutos: ");
        int min = leer.nextInt();  

        
        double horas = min / 60;
        double dias = min / 1440;
        
        System.out.println("El equivalente en días es: " + dias);
         System.out.println("El equivalente en horas es: " + horas);
    }
    
}
