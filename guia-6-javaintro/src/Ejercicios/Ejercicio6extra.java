/*
Leer la altura de N personas y determinar el promedio de estaturas que se encuentran por
debajo de 1.60 mts. y el promedio de estaturas en general.

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
public class Ejercicio6extra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner leer = new Scanner (System.in);
       System.out.println("Ingrese el número de personas a calcular: ");
       int N = leer.nextInt(); 
       int i = 0;
       int j;
       int p;
       double alt_total = 0;
       double alt_men = 0;
       double PromedioTotal;
       double PromedioMenor;

           for (j = 0; j < N; j++){
           p = j + 1;
           System.out.println("Ingrese la altura de la persona " + p + " en metros: ");
           double num = leer.nextDouble(); 
           alt_total = alt_total + num;
           if (num < 1.6){
              alt_men = alt_men + num;
              i++;
            }
           }
           PromedioTotal = alt_total / N;
           System.out.println("El promedio gral de las personas es: " + PromedioTotal + " metros");
           
           if (alt_men>0){
           PromedioMenor = alt_men / i;
           System.out.println("El promedio de las personas menores a 1.6 metros es: " + PromedioMenor + " metros");
           }else {
           System.out.println("No hay personas menores que 1,6 metros");
           }
    }
}