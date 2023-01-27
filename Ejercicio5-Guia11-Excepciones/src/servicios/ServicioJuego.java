/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Juego;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class ServicioJuego {
    
    
    Scanner leer = new Scanner(System.in);
    Juego juego = new Juego();
    
    
    public void crearJuego(){

   int intentos = 0;   
   Random aleatorio = new Random(System.currentTimeMillis());
   // Producir nuevo int aleatorio entre 0 y 10
   int intAletorio = aleatorio.nextInt(11);
   juego.setNumAdivinar(intAletorio);
      
    do{
      try { 
        
        System.out.println("Ingrese un nuevo número a adivinar entre 0 y 10");
        juego.setNumElegido(Integer.parseInt(leer.next()));

      
        
        
           if (juego.getNumElegido() > juego.getNumAdivinar()){
               System.out.println("Su numero seleccionado es mayor al que debe adivinar");
               intentos ++;
               System.out.println("Ingese nuevamnete el numero a adivinar: ");
               juego.setNumElegido(Integer.parseInt(leer.next()));
               intentos ++;
               
           }
           if (juego.getNumElegido() < juego.getNumAdivinar()){
               System.out.println("Su número seleccionado es menor al que debe adivinar");
               intentos ++;
               System.out.println("Ingese nuevamnete el número a adivinar: ");
               juego.setNumElegido(Integer.parseInt(leer.next()));
               intentos ++;
           }
        
        }
       catch(Exception e) {
          System.out.println("No seleccionó un número intentelo nuevamente: ");
          
          intentos ++;
        
          
       }
      } while (juego.getNumAdivinar()!=juego.getNumElegido());
      
            System.out.println("A encontrado el número a adivinar que es el: "+ juego.getNumElegido());
            System.out.println("La cantidad de intentos que tuvo es: " + intentos);
        
    }
}
    
    
    

