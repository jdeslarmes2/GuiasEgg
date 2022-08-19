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
public class Ejercicio11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el número a calcular: ");
        int num1 = leer.nextInt();
          System.out.println("Ingrese el segundo número a calcular: ");
        int num2 = leer.nextInt();
        boolean bandera = false;
        
        do {
            System.out.println("MENU"); 
            System.out.println("1. Sumar"); 
            System.out.println("2. Restar"); 
            System.out.println("3. Multiplicar"); 
            System.out.println("4. Dividir"); 
            System.out.println("5. Salir"); 
            System.out.println("Por favor ingrese una opción"); 
            int opcion = leer.nextInt();
            
            switch(opcion){
                case 1:
                    int suma = num1 + num2;
                 System.out.println("El resultado de la suma es: " + suma);  
                 break;
                    case 2:
                    int resta = num1 - num2;
                 System.out.println("El resultado de la suma es: " + resta); 
                 break;
                  case 3:
                    int mult = num1 * num2;
                 System.out.println("El resultado de la suma es: " + mult); 
                 break;
                  case 4:
                   double div = (double) num1 / num2;
                 System.out.println("El resultado de la suma es: " + div); 
                 break;
                 
                  case 5:
                 System.out.println("¿Esta seguro de salir? (S/N)"); 
                 
                 
                 String respuesta = leer.nextLine();
                 respuesta = leer.nextLine();
                 if (respuesta.equals("S")) {
                     bandera = true;

                     
                 }
                 
              }
                       
        }while (bandera == false);
            System.out.println("Gracias, hasta luego.");
    }
   }
    
    

