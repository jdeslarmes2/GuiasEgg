/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3extra.guia7.poo;

import Entidades.Raices;
import Servicio.ServicioRaices;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio3extraGuia7POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Scanner leer = new Scanner(System.in);
        
        ServicioRaices sr = new ServicioRaices();
        
        Raices r1 = sr.crearAtributos();
        
    //Calculo del discriminante
        
        System.out.println("El valor del discriminante es: "+ sr.getDiscriminante());
        
    //Verificación si tiene dos soluciones la raiz
         System.out.println("---------------Método para verificar si tiene dos soluciones de raices-------------- ");

        if (sr.tieneRaices()== true){
        System.out.println("La raiz tiene dos soluciones");
        } else {
        System.out.println("La raiz no tiene dos soluciones");
        }
        
    //Verificación si tiene una única solución
        System.out.println("---------------Método para verificar si tiene única solución de raiz-------------- ");

        if (sr.tieneRaiz()== true){
        System.out.println("La raiz tiene única solución");
        } else {
        System.out.println("La raiz no tiene única solución");
        }
        
     //Verificación si tiene dos soluciones   
        System.out.println("---------------Método obtener soluciones de Raices-------------- ");
        sr.obtenerRaices();
        
     //Verificación si tiene una única solición
       System.out.println("---------------Método obtener solución de Raiz----------------- ");
       sr.obtenerRaiz();
       
    //Verificación si tiene dos soluciones o una única solución
       System.out.println("---------Método calcular ambas soluciones---------------------- ");
       sr.calcular();
        
    }
    
}
