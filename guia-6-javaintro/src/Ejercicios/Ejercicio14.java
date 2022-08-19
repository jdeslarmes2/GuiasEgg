/*Crea una aplicación que a través de una función nos convierta una cantidad de euros
introducida por teclado a otra moneda, estas pueden ser a dólares, yenes o libras. La
función tendrá como parámetros, la cantidad de euros y la moneda a converir que será
una cadena, este no devolverá ningún valor y mostrará un mensaje indicando el cambio
(void).
El cambio de divisas es:
* 0.86 libras es un 1 €
* 1.28611 $ es un 1 €
* 129.852 yenes es un 1 €
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
public class Ejercicio14 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String moneda = "";
        int intentos = 0;
 
   //     do {
   //     System.out.println("Ingrese la moneda a cambiar (L) Libras, (D) dolares e (Y) yenes: ");
   //     moneda = leer.nextLine();
   //      } while (!moneda.equals("L") && !moneda.equals("D") && !moneda.equals("Y"));
       
     do {
     System.out.println("Ingrese la moneda a cambiar (L) Libras, (D) dolares e (Y) yenes: ");
     moneda = leer.nextLine();
     intentos++;
     }while(!moneda.equals("L") && !moneda.equals("D") && !moneda.equals("Y") && intentos < 3);
     
     if (moneda.equals("L") || moneda.equals("D") || moneda.equals("Y")) {
     
        System.out.println("Ingrese la cantidad de euros a cambiar: ");
        int euros = leer.nextInt();

        double retorno = conver(moneda, euros);
     } else {
       System.out.println("Su moneda a cambiar es incorrecta, ingrese en otro momento.");
      }
    
        
        
    }

      public static double conver(String moneda, int euros){
        
        double cambio = 0;
        

        
        switch (moneda) {

            case "L":
                cambio = 0.86 * euros;
                System.out.println("Su cambio en lbras es: " + cambio);
                break;
            case "D":
                cambio = 1.28611 * euros;
                System.out.println("Su cambio en dolares es: " + cambio);
                break;
            case "Y":
                cambio = 129.852 * euros;
                System.out.println("Su cambio en yenes es: " + cambio);
                break;
            default:
                System.out.println("Su moneda es incorrecta");
                       
        }
            
                
         return cambio;       
 
      }
}

    

