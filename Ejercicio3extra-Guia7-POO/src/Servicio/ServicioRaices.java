/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidades.Raices;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class ServicioRaices {

    Scanner leer = new Scanner(System.in);
   
    Raices r1 = new Raices();
    
    public Raices crearAtributos(){
        
        System.out.println("Ingrese el valor del atributo a: ");
        r1.setA(leer.nextInt()); 
        System.out.println("Ingrese el valor del atributo b: ");
        r1.setB(leer.nextInt());
        System.out.println("Ingrese el valor del atributo c: ");
        r1.setC(leer.nextInt());
        
        return r1;
    }
        
        
    public double getDiscriminante(){
       
       double discriminante =  (r1.getB()*r1.getB()) - 4 * r1.getA() * r1.getC();
       
       return discriminante;
   }
    
   
    public boolean tieneRaices(){
        
        double discriminante =  (r1.getB()*r1.getB()) - 4 * r1.getA() * r1.getC();
        boolean solucion;
        
        if (discriminante > 0){
            solucion = true;
        } else {
            solucion = false;
        }
        return solucion;
    }
    
    public boolean tieneRaiz(){
        
        double discriminante =  (r1.getB()*r1.getB()) - 4 * r1.getA() * r1.getC();
        boolean solucion;
        
        if (discriminante == 0){
            solucion = true;
        } else {
            solucion = false;
        }
        return solucion;
    }
    
    public void obtenerRaices(){
        
            
        double discriminante =  (r1.getB()*r1.getB()) - 4 * r1.getA() * r1.getC();
        boolean solucion = tieneRaices();
        
        if (solucion == true){
            double resultado1 = (-(r1.getB()) * Math.sqrt(discriminante)) / (2*r1.getA());
            double resultado2 = (r1.getB() * Math.sqrt(discriminante)) / (2*r1.getA());
            System.out.println("Las soluciones de las raices son: "+ resultado1+ " y "+ resultado2);
        } else {
            System.out.println("No tiene dos soluciones las raices");
        }
    }
    
        
    public void obtenerRaiz(){
        
            
        double discriminante =  (r1.getB()*r1.getB()) - 4 * r1.getA() * r1.getC();
        boolean solucion = tieneRaiz();
        
        if (solucion == true){
            double resultado = (-(r1.getB()) * Math.sqrt(discriminante)) / (2*r1.getA());
            System.out.println("La única solución de la raiz es: "+ resultado);
        } else {
            System.out.println("No tiene única solución");
        }
    }
        
    public void calcular(){
        
            
        double discriminante =  (r1.getB()*r1.getB()) - 4 * r1.getA() * r1.getC();
        boolean solucion = tieneRaiz();
        boolean solucion1 = tieneRaices();
        
        if (solucion == true){
            double resultado = (-(r1.getB()) * Math.sqrt(discriminante)) / (2*r1.getA());
            System.out.println("La única solución de la raiz es: "+ resultado);
        } if(solucion == false) {
            System.out.println("No tiene única solución");
        }
        
        if (solucion1 == true){
            double resultado1 = (-(r1.getB()) * Math.sqrt(discriminante)) / (2*r1.getA());
            double resultado2 = (r1.getB() * Math.sqrt(discriminante)) / (2*r1.getA());
            System.out.println("Las soluciones de las raices son: "+ resultado1+ " y "+ resultado2);
        } else {
            System.out.println("No tiene dos soluciones las raices");
        }
    }
        
}
        
        


