/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.guia10.herencia;

import entidades.Electrodomestico;
import entidades.Lavadora;
import entidades.Televisor;
import java.util.ArrayList;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio2Guia10Herencia {


    public static void main(String[] args) {
        
        ArrayList <Electrodomestico> electrodomesticos = new ArrayList();
       
        Lavadora l1 = new Lavadora();

        l1.crearLavadora();
        //l1.precioFinal();
        electrodomesticos.add(l1);
        
        Lavadora l2 = new Lavadora();
        l2.crearLavadora();
        //l2.precioFinal();
        electrodomesticos.add(l2);
        
        Televisor t1 = new Televisor();
        t1.crearTelevisor();
        //t1.precioFinal();
        electrodomesticos.add(t1);
        
        Televisor t2 = new Televisor();
        
        t2.crearTelevisor();
        //t2.precioFinal();
        electrodomesticos.add(t2);
        
        //Muestro el array
        
        for (Electrodomestico aux : electrodomesticos) {
            System.out.println(aux.toString());
        }
        
        //Recorro el arrray para generar el precio final y mostrar el precio de cada electrodoméstico
        
        for (Electrodomestico aux : electrodomesticos) {
            aux.precioFinal();
            System.out.println("");
            System.out.println("El precio final del electrodoméstico es: "+ aux.getPrecio());
            
        }
        double precioLavadoras = 0;
        double precioTelevisores = 0;
        for (int i = 0; i < electrodomesticos.size(); i++) {
            if(electrodomesticos.get(i) instanceof Lavadora){
              precioLavadoras = precioLavadoras + electrodomesticos.get(i).getPrecio();
            } else {
              precioTelevisores = precioTelevisores + electrodomesticos.get(i).getPrecio();
            }
        }
        System.out.println("");
        System.out.println("La sumatoria de todos los precios de las Lavadoras es: "+ precioLavadoras);
        System.out.println("");
        System.out.println("La sumatoria de todos los precios de las TVs es: "+ precioTelevisores);
        
        
        /*
                Parte de Ejercicio 2 para mostrar el precio final y los objetos 
        double precioFinalLavadora = l1.getPrecio();
        double precioFinalTelevisor = t1.getPrecio();
        System.out.println("El precio final de la lavadora es: " + precioFinalLavadora);
        System.out.println("El precio final del televisor es: "+ precioFinalTelevisor);
        System.out.println("");
        System.out.println("Su lavadora tiene los siguientes atributos:");
        System.out.println(l1.toString());
        System.out.println("");
        System.out.println("Su tv tiene los siguientes atributos: ");
        System.out.println(t1.toString());
        */
        
        
        
        
    }
    
}
