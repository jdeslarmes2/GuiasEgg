/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Arreglo;
import java.util.Arrays;

import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class ArregloServicio {
    
    Scanner leer = new Scanner(System.in);  
    
    
//Crear objeto donde coloco resultado de completar 
    
    Arreglo a1 = new Arreglo();

//Creo función para completar datos de objeto 
        
    public void crearArregloA(){
    
    double[] aux = new double[50];
    
        for (int i=0; i < aux.length; i++){
        Arrays.fill(aux, i, i+1, Math.random()*100);
        }
        a1.setArregloA(aux); 
        System.out.println("---------Creo Arreglo A-------------");
        System.out.print(Arrays.toString(a1.getArregloA()));   
        System.out.println("");
    }
    
    public void ordenarArregloA(){
    
    double [] aux = a1.getArregloA();
        Arrays.sort(aux);
        a1.setArregloA(aux);
        System.out.println("---------Ordenar Arreglo A-------------");
        System.out.print(Arrays.toString(a1.getArregloA()));
        System.out.println("");
    }    
            
    public void crearArregloB(){
    
    double [] aux1 = a1.getArregloA();
    double[] aux = new double[20];

        
        //Completo los primeros 10 valores del array de 20 y luego los 10 valores restantes.
        for (int i=0; i < 10; i++){
        aux [i] = aux1[i];
        a1.setArregloB(aux);
        }
        for (int i=10; i < 20; i++){
        aux [i] = 0.5;    
        a1.setArregloB(aux);
        }    
        System.out.println("---------Creo Arreglo B-------------");
        System.out.print(Arrays.toString(a1.getArregloB()));   
        System.out.println("");
    }    
            
}
    
    
    
    

