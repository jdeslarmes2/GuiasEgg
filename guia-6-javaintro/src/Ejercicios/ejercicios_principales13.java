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
public class ejercicios_principales13 {

    /**
     * @param args the command line arguments
     * Dibujar un cuadrado de N elementos por lado utilizando el carácter “*”. Por ejemplo, si el
cuadrado tiene 4 elementos por lado se deberá dibujar lo siguiente:
     */
    public static void main(String[] args) {
       Scanner leer = new Scanner(System.in);
       System.out.println("Por favor ingrese un número.");
       int num = leer.nextInt();
       
       for(int i = 0; i < num; i++ ){
           for(int f = 0; f < num; f++ ){
               if (i == 0 || f == num-1 || f == 0 || i == num-1){
                   System.out.print("* ");
               }else {
                   System.out.print("  ");
               }
                   
                   
           }
           System.out.println(" ");
    }
    
}
}
