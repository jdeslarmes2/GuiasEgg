/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

/**
 *
 * @author jdeslarmes
 */
public class Matriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        int[][] matriz = new int[3][3];
        
        for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                matriz[i][j] = 6;
                }
            }    

       
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                 System.out.print(matriz [i][j]);
                }
             System.out.println("");
        }    
        
        
    }
    
}
