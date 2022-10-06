/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Jugador;
import entidades.RevolverDeAgua;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author jdeslarmes
 */
public class ServicioJugador {
    
 Scanner leer = new Scanner(System.in);
  
  Jugador j = new Jugador();
  
  ServicioRevolverDeAgua sr = new ServicioRevolverDeAgua();
  
  ArrayList <Jugador> jugadores = new ArrayList();
  
  
  public  ArrayList <Jugador> crearNumeroYJugadores(){
     
      //Creo número de jugadores
      
      System.out.println("Ingrese el número de jugadores (del 1 al 6): ");
      int numJugadores = leer.nextInt();
      if (!(numJugadores <= 6 && numJugadores>=1)) {
          numJugadores = 6;
      }
      //Creo los jugadores
          int contador = 0;
           for (int i = 0; i < numJugadores; i++) {
              j.setId(contador + 1);
              contador ++;
              j.setNombre("Jugador" + j.getId());
              j.setMojado(true);
              
              //Creo objeto para agregar en ArrayList     
              Jugador j1 = new Jugador(j.getId(), j.getNombre(), j.isMojado());
      
              //Agrego cada jugador en Array List
               jugadores.add(j1);
           }
       // Cargo Array List de jugadores en el atributo del objeto Jugador
        j.setJugadores(jugadores); 
        return j.getJugadores();
      }
  
  
  public boolean disparo(RevolverDeAgua r){
      
      
      boolean respuesta;
      sr.siguienteChorro(r);
      sr.mostrarRevolver(r);
      System.out.println("El jugador se apunta con la pistola de agua");
      boolean verifMojado = sr.mojar(r);
      if (verifMojado == true) {
       //   j.setMojado(false);
          System.out.println("El jugador se ha mojado"); 
            respuesta = true;
      }else {
           respuesta = false;
          System.out.println("El jugador NO se ha mojado");
      } 
      return respuesta;
 }  
}