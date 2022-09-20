/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class ServicioRaza {
    
    private Scanner leer;
    private ArrayList<String> razas;

    public ServicioRaza() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.razas = new ArrayList();
    }

    
   public void crearRaza(){
       
       System.out.println("Ingrese la nueva raza de perro: ");
       String raza = leer.next();
       razas.add(raza);
       String respuesta = null;
       do {
       System.out.println("¿Si quiere guardar otra raza opima G, o si quiere salir opima S: ");
       respuesta = leer.next();
       if(respuesta.equalsIgnoreCase("G")){
           System.out.println("Ingrese la nueva raza de perro: ");
           raza = leer.next();
           razas.add(raza);
          }if (respuesta.equalsIgnoreCase("S")){
           break;
          } if(!respuesta.equalsIgnoreCase("G") && !respuesta.equalsIgnoreCase("S")) {
              System.out.println("Su respuesta a sido incorrecta");
          }
       }while(respuesta.equalsIgnoreCase("G"));
       
    
     
   }
   
   public void mostrarRaza(){
       System.out.println("Las razas actuales de la lista de razas son: ");
       for (String aux : razas) {
           System.out.println(aux);
       }
       System.out.println("cantidad = "+ razas.size());
   }
    
}
