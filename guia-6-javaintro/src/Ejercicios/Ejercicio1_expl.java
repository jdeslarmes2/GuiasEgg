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
public class Ejercicio1_expl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Tpublic static void main(String[] args) {
 Scanner leer = new Scanner(System.in);
 System.out.println("Ingrese el primer número a sumar");
 int num1 = leer.nextInt();
 System.out.println("Ingrese el segundo número a sumar");
 int num2 = leer.nextInt();
 int suma = num1 + num2;
 System.out.println("La suma de sus números es: " + suma);

}

    }
    

