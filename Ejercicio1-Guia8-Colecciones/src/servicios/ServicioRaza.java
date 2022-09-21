/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.ArrayList;
import java.util.Iterator;
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
         System.out.println("¿Si quiere guardar otra raza oprima G, o si quiere salir oprima S: ");
         respuesta = leer.next();
           if(respuesta.equalsIgnoreCase("G")){
             System.out.println("Ingrese la nueva raza de perro: ");
             raza = leer.next();
             razas.add(raza);
           }if (respuesta.equalsIgnoreCase("S")){
            break;
           }if(!respuesta.equalsIgnoreCase("G") && !respuesta.equalsIgnoreCase("S")) {
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
    
   public void verificarRaza(){
       
       System.out.println("Ingrese la raza a verificar y borrar: ");
       String respuesta = leer.next();
       int cantidadRazas = razas.size();
//   
// -----------Forma de resolverlo sin el Iterador------------------   
//       
//       
//       for (int i= 0; i < razas.size(); i++){
//           
//           String raza = razas.get(i);
//           if (raza.equalsIgnoreCase(respuesta)){
//               razas.remove(i);
//           } 
//         }
//        if (cantidadRazas == razas.size()){
//            System.out.println("No se encontro la raza a borrar");
//        }
//       
//   }
//------------------------------------------------------------------
   
         Iterator<String> it = razas.iterator();
         
         while (it.hasNext()) {
           String aux = it.next();
           
           if(aux.equalsIgnoreCase(respuesta)){
               it.remove();
           }
         }
         if (cantidadRazas == razas.size()){
            System.out.println("No se encontro la raza a borrar");
        }    
   }   
   
}
