/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Matematicas;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class MatematicasServicio {
    
    Scanner leer = new Scanner(System.in);
    
    Matematicas objeto = new Matematicas();
    
    public Matematicas crearObjeto(){
        
        objeto.setNumero1(Math.random()*100);
        
        objeto.setNumero2(Math.random()*100);
        
        return objeto;
    }
    
    
    public void devolverMayor(Matematicas objeto){
        
        System.out.println("----Calculo de devolver Mayor----");
        if (objeto.getNumero1()> objeto.getNumero2()){
            System.out.println("El valor mayor es el numero 1: "+ objeto.getNumero1()+ " que el valor del numero 2: "+ objeto.getNumero2() );
        } else
            System.out.println("El valor mayor es el numero 2: "+ objeto.getNumero2()+ " que el valor del numero 1: "+ objeto.getNumero1());
        
    }
    
     public void calcularPotencia(Matematicas objeto){
        
        System.out.println("----Calculo de calcular la potencia del número mayor a la potencia del número menor----");
        if (objeto.getNumero1()> objeto.getNumero2()){
            
            long argumento = Math.round(objeto.getNumero1());
            System.out.println("El primer argumento redondeado es: "+argumento);
            long potencia = Math.round(objeto.getNumero2());
            System.out.println("El segundo argumento de la potencia redondeada es: "+potencia);
            
            Double resultado = Math.pow(argumento, potencia);
            
            System.out.println("El resultado del calculo de potencia es: "+ resultado);
        } else {
            long argumento = Math.round(objeto.getNumero2());
            System.out.println("El primer argumento redondeado es: "+argumento);
            long potencia = Math.round(objeto.getNumero1());
            System.out.println("El segundo argumento de la potencia redondeada es: "+potencia);
            
            Double resultado = Math.pow(argumento, potencia);
            
            System.out.println("El resultado del calculo de potencia es: "+ resultado);
        }
     }
    
         public void calcularRaiz(Matematicas objeto){
        
        System.out.println("----Calculo de calcular la raiz cuadrada del número menor----");   
        if (objeto.getNumero1()< objeto.getNumero2()){
            
            System.out.println("El numero 1 es: "+ objeto.getNumero1() + " y el numero 2 es: "+ objeto.getNumero2());
            
            Double absolutoNumero1 = Math.abs(objeto.getNumero1());
            System.out.println("El absoluto del numero 1 es: "+ absolutoNumero1);
            long argumento = Math.round(absolutoNumero1);
            System.out.println("El argumento redondeado del número 1 es: "+argumento);
            
            Double resultadoraiz = Math.sqrt(argumento);
            
            System.out.println("El resultado de la raiz cuadrada de :"+argumento+ " es: "+ resultadoraiz);
        } else {
            Double absolutoNumero2 = Math.abs(objeto.getNumero2());
            System.out.println("El absoluto del numero 2 es: "+ absolutoNumero2);
            long argumento = Math.round(absolutoNumero2);
            System.out.println("El argumento redondeado del número 2 es: "+argumento);
            
            Double resultadoraiz = Math.sqrt(argumento);
            
            System.out.println("El resultado de la raiz cuadrada de: "+argumento+ " es: "+ resultadoraiz);
        }
     }
}
