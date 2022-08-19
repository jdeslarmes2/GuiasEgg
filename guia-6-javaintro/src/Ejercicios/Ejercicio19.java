/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6ej19;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Ejercicio19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int n=3;
        int [][] matriz = new int[n][n];
        int [][] traspuesta = new int[n][n];
    
        
        cargarMatriz(matriz,n);
        System.out.println("Matriz Original: ");
        System.out.println("");
        mostrarMatriz(matriz,n);
        System.out.println("");
        System.out.println("");
        trasponerMatriz(matriz,traspuesta,n);
        System.out.println("");
        System.out.println("");
        System.out.print("Matriz Antisimétrica: ");
        validarAntiSimetrica(matriz,traspuesta,n);
    }
    //----------------------------------------------//
    public static void cargarMatriz(int matriz[][], int n)
    {
        Scanner leer = new Scanner(System.in);
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.println("Posicion [" + i + "]" + "[" + j + "]?");
                matriz[i][j] = leer.nextInt();
            }
        }
            
    }
//----------------------------------------------//
    public static void mostrarMatriz(int matriz[][], int n)
    {
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print("[" + matriz[i][j] + "]" + "\t");
                
            }
            System.out.println("");
        }
            
    }    
    
//----------------------------------------------//
    public static void trasponerMatriz(int matriz[][],int traspuesta[][], int n)
    {
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                traspuesta[i][j] = matriz[j][i];
                
            }
        }
        
        System.out.println("Traspuesta");
        System.out.println("");
        mostrarMatriz(traspuesta,n);    
    }    
    
//----------------------------------------------// 
    public static void validarAntiSimetrica(int matriz[][],int traspuesta[][],int n)
    {
            int contador = 0;
            int [][] antisimetrica = new int[n][n];

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(matriz[i][j] == (-1)*(traspuesta[i][j]))
                    {

                        contador++;
                    }

                }
            }
            
            if(contador == n*n)
                {
                    System.out.println("Sí.");
                    System.out.println("");
                    for(int i=0;i<n;i++)
                    {
                        for(int j=0;j<n;j++)
                        {
                            antisimetrica[i][j] = (-1)*(traspuesta[i][j]);
                        }    

                    }
                    mostrarMatriz(antisimetrica,n);
                }
                else
                {
                    System.out.println("No.");
                }

            
        
    }

}
