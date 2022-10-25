/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Cine;
import entidades.Espectador;
import entidades.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class servicioEspectador {
    
    
    Scanner leer = new Scanner(System.in);
    Espectador e1 = new Espectador();  
    Pelicula p1 = new Pelicula();
    Cine c1 = new Cine();
    //Declaro un listado HashSet para asegurarme que los objetos espectadores sean diferentes.
    ArrayList <Espectador> Espectadores = new ArrayList();
    
    
    public void crearEspectador(){
        
        System.out.println("Ingrese el nombre del espectador: ");
        e1.setNombre(leer.next());
        System.out.println("Ingrese la edad del espectador: ");
        e1.setEdad(leer.nextInt());
        System.out.println("Ingrese el dinero del espectador: ");
        e1.setDinero(leer.nextDouble());

            
    }
    
   public ArrayList crearListaPosiblesEspectadores(){
       
    // Creo 10 espectadores y lo pongo un Array List  local que luego paso en el método, para luego pasarlo al objeto si solo si tienen suficiente dinero y pueden ver la película por su edad
       
       for (int i = 0; i < 10; i++) {
             crearEspectador();
             if (e1.getEdad()> p1.getEdadMinima() && e1.getDinero()>c1.getPrecio()){
               Espectadores.add(e1);
             } else {
                 if (e1.getEdad()< p1.getEdadMinima()){
                 System.out.println("El espectador" + e1.getNombre()+ " no tiene la edad suficiente para ingresar a la sala");
                 }  if (e1.getDinero()<c1.getPrecio()){
                 System.out.println("El espectador" + e1.getNombre()+ " no tiene suficiente edad para ingresar a la sala");    
                 }  
             }
       } 
       System.out.println("---------------Muestro el conjunto de espectadores antes de mezclarlo -----------------");
       
       for (Espectador aux : Espectadores) {
           System.out.println(aux);
       }

       Collections.shuffle(Espectadores);
       
            System.out.println("---------------Muestro el conjunto de espectadores luego de mezclarlo -----------------");
       
       for (Espectador aux : Espectadores) {
           System.out.println(aux);
       }  
        return Espectadores;
    }
}
