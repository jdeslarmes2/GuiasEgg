/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *Simular la división usando solamente restas. Dados dos números enteros mayores que
uno, realizar un algoritmo que calcule el cociente y el residuo usando sólo restas. Método:
Restar el dividendo del divisor hasta obtener un resultado menor que el divisor, este
resultado es el residuo, y el número de restas realizadas es el cociente.
Por ejemplo: 50 / 13:
50 – 13 = 37 una resta realizada
37 – 13 = 24 dos restas realizadas
24 – 13 = 11 tres restas realizadas
dado que 11 es menor que 13, entonces: el residuo es 11 y el cociente es 3.
¿Aún no lo entendiste? Recomendamos googlear división con restas sucesivas.
 * @author jdeslarmes
 */
public class Ejercicio9extra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             Scanner leer = new Scanner (System.in);
           int num1,num2;
           int resta =0;
           int cantResta =1;
           int numImpar =0;
           double resto;
           
       System.out.println("Ingrese el divisor entero a dividir: ");
       num1 = leer.nextInt();
       System.out.println("Ingrese el dividendo entero a dividir: ");
       num2 = leer.nextInt();
           
 
       resta = num1 - num2;
       if (resta>num2){
           do{
              resta = resta - num2;
              cantResta++;
           }while (resta>num2);
        }
 
  System.out.println("El resto es: " + resta);
  System.out.println("El cociente es: " + cantResta);       

    }
    
}
