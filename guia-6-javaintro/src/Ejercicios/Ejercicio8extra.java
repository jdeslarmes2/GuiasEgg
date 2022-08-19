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
public class Ejercicio8extra {

    /**
     * Escriba un programa que lea números enteros. Si el número es múltiplo de cinco debe
       detener la lectura y mostrar la cantidad de números leídos, la cantidad de números pares y
       la cantidad de números impares. Al igual que en el ejercicio anterior los números
       negativos no deben sumarse. Nota: recordar el uso de la sentencia break.
       * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Scanner leer = new Scanner (System.in);
           int num;
           int numLeido =0;
           int numPar =0;
           int numImpar =0;
           double resto;
 do{
       System.out.println("Ingrese el número entero a leer: ");
       num = leer.nextInt();
       numLeido++;

       if (num%2 == 0) {
           numPar++;
       }else {
           numImpar++;
       }
    }while (num % 5!= 0);
  System.out.println("La cantidad de números ingresada fue: " + numLeido);
  System.out.println("La cantidad de números pares fue: " + numPar);
  System.out.println("La cantidad de números impares fue: " + numImpar);
    }
    
}
