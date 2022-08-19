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
 * Dadas dos matrices cuadradas de números enteros, la matriz M de 10x10 y la matriz P de
3x3, se solicita escribir un programa en el cual se compruebe si la matriz P está contenida
dentro de la matriz M. Para ello se debe verificar si entre todas las submatrices de 3x3 que
se pueden formar en la matriz M, desplazándose por filas o columnas, existe al menos una
que coincida con la matriz P. En ese caso, el programa debe indicar la fila y la columna de
la matriz M en la cual empieza el primer elemento de la submatriz P.
 */
public class ejercicios_principal21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 Scanner leer = new Scanner(System.in);
 int [][] matrizM = new int [10][10];
 int [][] matrizP = new int [3][3];
 int max = 99;
 int min = 0; 
 int a = 0;
 int b = 0;
         
 for (int i = 0; i < 10; i++){
        for (int j = 0; j < 10; j++){
            matrizM[i][j] = (int) (Math.random()*(max-min) + min);
            System.out.print("[" + matrizM [i][j] + "]");
        }
        System.out.println("");
}    
  for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            System.out.println("Ingresar valor");
            matrizP [i][j] = leer.nextInt();
        }
}    
  for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            System.out.print("[" + matrizP [i][j] + "]");
        }
        System.out.println("");
}    
 int fila = 3;
 int lim1 = fila + 3;
 int columna = 3;
 int lim2 = columna + 3;
 int cont = 0;
 double posicion = 0;
  for (int i = fila; i < lim1; i++){
      for(int j = columna; j < lim2; j++){
          if (matrizM [i][j] == matrizP [a][b]){
              cont++;
              posicion = i + j/10
          }
          b++;
      }
      a++;
      b = 0;
  }
  }
}
   
}
    
