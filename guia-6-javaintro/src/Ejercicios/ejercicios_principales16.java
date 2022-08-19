/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introJava_ejercicios_principales;

import static java.lang.Math.random;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ejercicios_principales16 {

    /**
     * @param args the command line arguments
     * Realizar un algoritmo que rellene un vector de tamaño N con valores aleatorios y le pida al
usuario un numero a buscar en el vector. El programa mostrará donde se encuentra el
numero y si se encuentra repetido
     */
    public static void main(String[] args) {
 Scanner leer = new Scanner(System.in);
 
  int[] vector = new int[100];
 int i;
 for (i=0;i<100;i++){
     vector[i] = (int)(Math.random()*100);
     System.out.print("[" + vector[i] + "]");
    }
 
        System.out.println(" ");
        System.out.println("Por favor ingrese el número a buscar");
 int num = leer.nextInt();
 
 int retorno = busqueda(num,vector);
 boolean retorno1 = encontrado(num,vector);
 int retorno2 = repetido(num,vector);
 if (retorno1 == false){
     System.out.println("No se encontraron coincidencias");
 }
 if (retorno1 == true){
        System.out.println("Se encontro el número " + num + " en la posición: " + retorno + " y se repite " + (retorno2 - 1) + " veces" );
 }

}
    public static int busqueda(int a, int b[]){
    int i;
    int busq = 0;
    for (i=0;i<100;i++) {
        if (a == b[i]){
            busq = i;       
        }
    
}
    return busq;
}
        public static boolean encontrado(int a, int b[]){
    int i;
    int cont=0;
    boolean bandera = false;
    for (i=0;i<100;i++) {
        if (a == b[i]){
            cont++;        
        }   
        if (cont > 0){
            bandera = true;
        }
}
return bandera;
        }
               public static int repetido(int a, int b[]){
    int i;
    int cont=0;
    boolean bandera = false;
    for (i=0;i<100;i++) {
        if (a == b[i]){
            cont++;        
        }   
    }
      
       
return cont;}
 
}