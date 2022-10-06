/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Juego;
import entidades.Jugador;
import entidades.RevolverDeAgua;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class ServicioJuego {
   
    Scanner leer = new Scanner(System.in);
    
    Juego ju = new Juego();
    
    ServicioJugador sj = new ServicioJugador();
  
    
    public void llenarJuego(ArrayList <Jugador> jugadores, RevolverDeAgua r1){
 
       ju.setJugadores(jugadores);
       ju.setRevolver(r1);
       
    }
    
    public boolean finJuego(){
           
           boolean bandera = false;
           for (int i = 0; i < ju.getJugadores().size(); i++) {
            
               Jugador mojado = ju.getJugadores().get(i);
               if (mojado.isMojado()== false){
                  bandera = true;
                  break;
               }
                 bandera = false;
            }
           return bandera;
    }     
           
        
        
        
//        for (Jugador aux : ju.getJugadores()) {
//            if (aux.isMojado() == false) {
//                System.out.println(aux.getNombre());
//                return true;
//            }
//        }
//        return false;
    
    
        public void ronda(){


       //      for (Jugador aux : ju.getJugadores()){
               
       //         sj.disparo(ju.getRevolver());
       //          System.out.println(ju.getRevolver());
         
              for (int i = 0; i < ju.getJugadores().size(); i++) {
                  
                  boolean esMojado = sj.disparo(ju.getRevolver());
                  if ( esMojado == true){
                      System.out.println("El juego se ha terminado, se ha mojado el jugador: "+ju.getJugadores().get(i).getNombre());
                      ju.getJugadores().get(i).setMojado(false);
                      break;
                   }
                }    
        }
    
}
