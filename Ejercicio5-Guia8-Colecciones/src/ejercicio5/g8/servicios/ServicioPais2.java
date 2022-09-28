/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5.g8.servicios;

import ejercicio5.g8.entidades.Pais2;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author jdeslarmes
 */
public class ServicioPais2 {
    
    Scanner leer = new Scanner(System.in);
    
    Pais2 p = new Pais2();
    
    TreeSet<Pais2> paises = new TreeSet();
    
    //Creo el país sin devolver un objeto, solo cargo el string en el TreeSet
    public Pais2 crearPais(){
        
        System.out.println("Ingrese el nombre del país: ");
        p.setNombre(leer.next());

        Pais2 p1 = new Pais2(p.getNombre());

        paises.add(p1);
        return p1;
    }
    
    public void agregarPais(){
        
        String respuesta = "";
        do {
        System.out.println("Desea agregar otro país? (S/N)");
        respuesta = leer.next();
          if (respuesta.equalsIgnoreCase("S")){
            crearPais();
          } if (respuesta.equalsIgnoreCase("N")){
            
              for (Pais2 aux : paises) {
                  System.out.println(aux);
              }
          }if(!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
            System.out.println("Su respuesta es incorrecta");
          }
            
        } while(!respuesta.equalsIgnoreCase("N"));

    }
    
    public void eliminarPais(){
        
        System.out.println("Ingrese el país a buscar y eliminar: ");
        Pais2 respuesta = new Pais2(leer.next());
        Iterator <Pais2> it = paises.iterator();
        
        while (it.hasNext()) {
            Pais2 aux = it.next();
            
            if (aux.getNombre().equals(respuesta.getNombre())){
                it.remove();
            } 
        }
        
    }    
}