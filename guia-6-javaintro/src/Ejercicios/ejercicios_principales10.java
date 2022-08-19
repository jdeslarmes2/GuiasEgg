/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introJava_ejercicios_principales;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ejercicios_principales10 {

    /**
     * @param args the command line arguments
     * Escriba un programa en el cual se ingrese un valor límite positivo, y a continuación solicite
números al usuario hasta que la suma de los números introducidos supere el límite inicial.
     */
    public static void main(String[] args) {
       Scanner leer = new Scanner(System.in);
        System.out.println("Por favor ingrese un límite.");
        int limite = leer.nextInt();
       int suma = 0;
       do {System.out.println("Por favor ingresar un número.");
       int num = leer.nextInt();
     
       suma = suma + num;
               
       } while (suma < limite);
       
        System.out.println("Se ha alcanzado el límite.");
    }
    
}
