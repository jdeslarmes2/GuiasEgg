/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5.g8.servicios;

import ejercicio5.g8.entidades.Pais;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author jdeslarmes
 */
public class ServicioPais {
    
    Scanner leer = new Scanner(System.in);
    
    Pais p = new Pais();
    
    TreeSet<String> paises = new TreeSet();
    
    //Creo el país sin devolver un objeto, solo cargo el string en el TreeSet
    public void crearPais(){
        
        System.out.println("Ingrese el nombre del país: ");
        p.setNombre(leer.next());

     //   Pais p1 = new Pais(p.getNombre());

        paises.add(p.getNombre());

    }
    
    public void agregarPais(){
        
        String respuesta = "";
        do {
        System.out.println("Desea agregar otro país? (S/N)");
        respuesta = leer.next();
          if (respuesta.equalsIgnoreCase("S")){
            crearPais();
          } if (respuesta.equalsIgnoreCase("N")){
            
              for (String aux : paises) {
                  System.out.println(aux);
              }
          }if(!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
            System.out.println("Su respuesta es incorrecta");
          }
            
        } while(!respuesta.equalsIgnoreCase("N"));

    }
    
    
    
}
