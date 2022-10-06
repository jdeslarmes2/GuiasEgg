/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.guia9.relaciones;

import entidades.Juego;
import entidades.Jugador;
import entidades.RevolverDeAgua;
import java.util.ArrayList;
import servicios.ServicioJuego;
import servicios.ServicioJugador;
import servicios.ServicioRevolverDeAgua;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio2Guia9Relaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Juego juego = new Juego();
        Jugador jugador = new Jugador();
        ServicioJuego sj = new ServicioJuego();
        ServicioJugador s2j = new ServicioJugador();
        ArrayList <Jugador> jugadores = new ArrayList();
        ServicioRevolverDeAgua sra = new ServicioRevolverDeAgua();
        
        
        //Creo número de Jugadores, Jugadores y Lista de Jugadores y traigo la lista de jugadores
        
            jugadores = s2j.crearNumeroYJugadores();
       
       // Cargo el revolver y lo traigo
       
            RevolverDeAgua revolver = sra.llenarRevolver();
           
            
       // Lleno el juego, lo lleno por que sino no carga el disparo
        
            sj.llenarJuego(jugadores, revolver);
       
       // Empiezo las rondas
         
       while (sj.finJuego()== false){
            sj.ronda();
       }
       
       
    }
    
}
