/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *Elaborar un algoritmo en el cuál se ingrese un número entre 1 y 10 y se muestre su
equivalente en romano.
 * @author jdeslarmes
 */
public class Ejercicio4extra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
       System.out.println("Ingrese número entre 1 y 9: ");
       int num = leer.nextInt(); 
       String num2 = null;
       
        switch (num) {
            case 1:
                num2 = "I";
                System.out.println("El número en romano es: " + num2);
                break;
            case 2:
                num2 = "II";
                System.out.println("El número en romano es: " + num2);
                break;
            case 3:
                num2 = "III";
                System.out.println("El número en romano es: " + num2);
                break;
            case 4:
                num2 = "IV";
                System.out.println("El número en romano es: " + num2);
                break;
            case 5:
                num2 = "V";
                System.out.println("El número en romano es: " + num2);
                break;
            case 6:
                num2 = "VI";
                System.out.println("El número en romano es: " + num2);
                break;
            case 7:
                num2 = "VII";
                System.out.println("El número en romano es: " + num2);
                break;
            case 8:
                num2 = "VIII";
                System.out.println("El número en romano es: " + num2);
                break;
            case 9:
                num2 = "IX";
                System.out.println("El número en romano es: " + num2);
                break;
            default:
                System.out.println("El número ingresado no es del 1 al 9");
                break;
        }
      
    }
    
}
