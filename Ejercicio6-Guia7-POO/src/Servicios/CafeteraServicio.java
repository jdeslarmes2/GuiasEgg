/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Cafetera;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class CafeteraServicio {
    
    Scanner leer = new Scanner (System.in);
    
    //Método llenar la cafetera
    
    public Cafetera crearCafetera(){
        
        Cafetera c1 = new Cafetera();
        
        System.out.println("Ingrese la cantidad actual de tazas de cafe de la cafetera: ");
        c1.setCantidadActual(leer.nextInt());
        System.out.println("Ingrese la cantidad máxima de tazas de cafe  de la cafetera: ");
        c1.setCapacidadMaxima(leer.nextInt());
        
        return c1;
       
    }
    
       public void llenarCafetera(Cafetera c1){
        
        c1.setCantidadActual(c1.getCapacidadMaxima());
           System.out.println("La cantidad de tazas de cafe que tiene la cafetera ahora es de: " + c1.getCantidadActual());
        
    }
    
       
    
    public void llenarTaza(Cafetera c1){
              
            
        System.out.println("Ingrese el tamaño de taza vacía: 1.Chica, 2.Media, 3.Grande");
        int taza = leer.nextInt();
        System.out.println("Sirviendo cafe");
        if (c1.getCantidadActual() < taza){
            int faltante =  taza - c1.getCantidadActual();
           switch (faltante){
               case 1:
                   System.out.println("Le falta completar 1/3 de taza");
                   break;
               case 2:
                   System.out.println("Le falta completar 2/3 de taza");
                   break;
            }
        } else 
            System.out.println("Su taza se ha llenado");
        
    }
    
        public void vaciarCafetera(Cafetera c1){
        
        c1.setCantidadActual(0);
        System.out.println("La cantidad de tazas de cafe que tiene la cafetera ahora es de: " + c1.getCantidadActual());
    }
    
        public void agregarCafe(Cafetera c1){
        
        System.out.println("Ingrese la cantidad de cafe que desea ingresar: 1. mitad de cafetera, 2. total de cafetera: ");
        int cafe = leer.nextInt();
        if (cafe == 1){
            System.out.println("Se completo la mitad de la cafetera");
        } if (cafe == 2){
            System.out.println("Se completo la totalidad de la cafetera");
        } else 
            System.out.println("La cantidad indicada es incorrecta");
        
    }
        
        
}
