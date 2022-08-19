/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *Un cuadrado mágico 3 x 3 es una matriz 3 x 3 formada por números del 1 al 9 donde la
suma de sus filas, sus columnas y sus diagonales son idénticas. Crear un programa que
permita introducir un cuadrado por teclado y determine si este cuadrado es mágico o no.
El programa deberá comprobar que los números introducidos son correctos, es decir,
están entre el 1 y el 9.
* 
 * @author jdeslarmes
 */
public class Ejercicio20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner leer = new Scanner (System.in);
      int n =3;
      int i;
      int j = 0;
      int [][] matriz = new int [3][3];
      
      //Pedir los valores de la matriz
      
      for(i = 0; i < 3; i++){
          for (j = 0; j < 3; j++){
              System.out.println("Ingrese el valor entero [" + i + "]" + "[" + j +"] de la matriz, del 1 al 9: ");
              matriz [i][j] = leer.nextInt();
          }
      }
      
      // Mostrar la matriz
      
        for(i = 0; i < 3; i++){
          for (j = 0; j < 3; j++){
              System.out.print("[" + matriz [i][j] + "]");
          }  
          System.out.println("");
        }
        
       
        System.out.println("La verificacion de las filas es: " + VerFilas(matriz, n, i, j));
        System.out.println("La verificacion de las columnas es: " + VerColumnas(matriz, n, i, j));
        System.out.println("La verificacion de las diagonales es: " + VerDiag(matriz, n, i, j));
        
        
       if (VerFilas(matriz, n, i, j) == true && VerColumnas(matriz, n, i, j) == true && VerDiag(matriz, n, i, j) == true){
        System.out.println("Su matriz es mágica!!");
       } 
       else {
        System.out.println("Su matriz no es mágica");        
      }
       
       if (VerNumCorrect(matriz, n, i, j) == false){
           System.out.println("Los números de la matriz están correctamente introducidos");
       } else if (VerNumCorrect(matriz, n, i, j) == true){
           System.out.println("Los números de la matriz son incorrectos, no todos están entre 0 y 9");
       }
       
    }
        
       
        // Funcion para comprobar filas de matriz
        
    public static boolean VerFilas(int matriz [][], int n, int i, int j){

        boolean retorno = false;
        int suma = 0;
        int verif =0;
        
         for (i = 0; i < 3; i++){
             
             if (i > 0) {
                 suma = 0;
             }
             
             for (j = 0; j < 3; j++){
             suma = suma + matriz [i][j];
                 
                  if (i == 0){
                  verif = suma;
                  retorno = false;
                  }
                  else if(suma == verif){ 
                     retorno = true;
                  }
                  else {
                      retorno = false;
                  }
             }
         }
         return retorno;
    }
        
         // Funcion para comprobar columnas de matriz
        
    public static boolean VerColumnas(int matriz [][], int n, int i, int j){

        boolean retorno = false;
        int suma = 0;
        int verif =0;
        
         for (j = 0; j < 3; j++){
             
             if (j > 0) {
                 suma = 0;
             }
             
             for (i = 0; i < 3; i++){
             suma = suma + matriz [i][j];
                 
                  if (j == 0){
                  verif = suma;
                  retorno = false;
                  }
                  else if(suma == verif){ 
                     retorno = true;
                  }
                  else {
                      retorno = false;
                  }
             }
         }
         return retorno;
    }
        
    // Funcion para verificacion de diagonales
    
     public static boolean VerDiag(int matriz [][], int n, int i, int j){

        boolean retorno;
        int suma = 0;
        int suma2 = 0;
       
        
         for (i = 0; i < 3; i++){
             for (j = 0; j < 3; j++){
                 
                 if (i==j){
                      suma = suma + matriz [i][j];
                 }
             }
         }
             
          for (j = 0; j < 3; j++){
             for (i = 0; i < 3; i++){
                 
                 if (i+j==2){
                      suma2 = suma2 + matriz [i][j];
                 }
             }
         }
         
          if (suma == suma2) {
              retorno = true;
          } else {
              retorno = false;
          }

         return retorno;
                
     }   
   
     
public static boolean VerNumCorrect(int matriz [][], int n, int i, int j){

        boolean retorno = false;
  
        
        int verif;

       
        
         for (i = 0; i < 3; i++){
             
             if (retorno == true){
                 break;
             }
             
             for (j = 0; j < 3; j++){
                 
                 verif = matriz [i][j];
                 
                 if (verif > 0 && verif < 9){
                      retorno = false;
                 } else {
                     retorno = true;
                     break;
                 }
            }
        }
         return retorno;
}

}
             
         
     
     
     
     

      
      
        


