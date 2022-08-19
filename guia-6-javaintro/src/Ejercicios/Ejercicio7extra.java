/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *Realice un programa que calcule y visualice el valor máximo, el valor mínimo y el promedio
de n números (n>0). El valor de n se solicitará al principio del programa y los números
serán introducidos por el usuario. Realice dos versiones del programa, una usando el
bucle “while” y otra con el bucle “do - while”.
 * @author jdeslarmes
 */
public class Ejercicio7extra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner leer = new Scanner (System.in);
       System.out.println("Ingrese la cantidad de N números a calcular: ");
       int N = leer.nextInt(); 
       double suma=0;
       int min=1000000;
       int max=0;
       int i=0;
       double promedio;

       
    do{
       System.out.println("Ingrese el número " + i + " a calcular");
       int num = leer.nextInt();
       suma = suma + num;  
       i++;
       if (num<min){
           min = num;
       }
       if (num>max){
           max=num;
       }
    }while (i<N);
    
    promedio = suma / N;
    System.out.println("Su valor máximo es: " + max);
    System.out.println("Su valor mínimo es: " + min);
    System.out.println("Su valor promedio es: " + promedio);
    
    
       }
    
}
