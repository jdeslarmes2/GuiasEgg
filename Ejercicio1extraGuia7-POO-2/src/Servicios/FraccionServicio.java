/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Fraccion;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class FraccionServicio {
    
    Scanner leer = new Scanner(System.in);

    
    public Fraccion crearFracciones(){
        
        Fraccion f1 = new Fraccion();
        
        System.out.println("Ingrese el numerador de la primera fracción: ");
        f1.setNumeradorFreacción1(leer.nextInt());
        System.out.println("Ingrese el denominador de la primera fracción: ");
        f1.setDenominadorFreacción1(leer.nextInt());
        System.out.println("Ingrese el numerador de la segunda fraccción: ");
        f1.setNumeradorFraccion2(leer.nextInt());
        System.out.println("Ingrese el denominador de la segunda fracción: ");
        f1.setDenominadorFraccion2(leer.nextInt()); 
 
        return f1; 

    }
    

    public void sumarFracciones(Fraccion f1){
        double fraccion1 = f1.getNumeradorFreacción1() / f1.getNumeradorFreacción1();
        double fraccion2 = f1.getNumeradorFraccion2() / f1.getDenominadorFraccion2();  
        double suma = fraccion1 + fraccion2;
        System.out.println("La suma de las dos fracciones es: "+suma);
        
    } 
    
     public void restaFracciones(Fraccion f1){
         double fraccion1 = f1.getNumeradorFreacción1() / f1.getNumeradorFreacción1();
    double fraccion2 = f1.getNumeradorFraccion2() / f1.getDenominadorFraccion2();  
        double resta = fraccion1 - fraccion2;
        System.out.println("La resta de las dos fracciones es: "+resta);
        
    } 
       public void multiplicacionFracciones(Fraccion f1){
         double fraccion1 = f1.getNumeradorFreacción1() / f1.getNumeradorFreacción1();
    double fraccion2 = f1.getNumeradorFraccion2() / f1.getDenominadorFraccion2();  
        double multiplicacion = fraccion1 * fraccion2;
        System.out.println("La multiplicación de las dos fracciones es: "+multiplicacion);
        
    } 
          public void divisionFracciones(Fraccion f1){
         double fraccion1 = f1.getNumeradorFreacción1() / f1.getNumeradorFreacción1();
    double fraccion2 = f1.getNumeradorFraccion2() / f1.getDenominadorFraccion2();  
        double division = fraccion1 / fraccion2;
        System.out.println("La multiplicación de las dos fracciones es: "+division);
        
    } 
    
}
