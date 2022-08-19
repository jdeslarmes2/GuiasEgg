/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *Una obra social tiene tres clases de socios:
o Los socios tipo ‘A’ abonan una cuota mayor, pero tienen un 50% de descuento en
todos los tipos de tratamientos.
o Los socios tipo ‘B’ abonan una cuota moderada y tienen un 35% de descuento para
los mismos tratamientos que los socios del tipo A.
o Los socios que menos aportan, los de tipo ‘C’, no reciben descuentos sobre dichos
tratamientos.
o Solicite una letra (carácter) que representa la clase de un socio, y luego un valor
real que represente el costo del tratamiento (previo al descuento) y determine el
importe en efectivo a pagar por dicho socio.
 * @author jdeslarmes
 */
public class Ejercicio5extra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Scanner leer = new Scanner (System.in);
       System.out.println("Ingrese una letra de tipo de socio (A,B o C): ");
       String letra = leer.nextLine(); 
       System.out.println("Ingrese el costo del tratamiento: ");
       int costo_ini = leer.nextInt(); 

       
       
       switch (letra) {
           case "A":  
           double costo = costo_ini * 0.5;
           System.out.println("El costo del tratamiento con el descuento es " + costo + "$");
           break;
           
           case "B":
           costo = costo_ini * 0.35;
           System.out.println("El costo del tratamiento con el descuento es " + costo + "$");
           break;
               
           case "C":
           costo = costo_ini;
           System.out.println("El costo del tratamiento es igual a " + costo + " $ no tiene descuentos");
           break;
               
           default:
           System.out.println("No existe dicho tipo de socio");  
           break;
}
    }
}