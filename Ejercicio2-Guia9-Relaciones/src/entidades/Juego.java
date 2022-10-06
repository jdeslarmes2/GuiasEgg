/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author jdeslarmes
 */
public class Juego {
    
private RevolverDeAgua revolver;
private ArrayList<Jugador> jugadores; //Creo relación de Composicion ya que si el "Juego" deja de existir no tiene sentido que existan los "Jugadores"

    public Juego() {
    }



    public RevolverDeAgua getRevolver() {
        return revolver;
    }

    public void setRevolver(RevolverDeAgua Revolver) {
        this.revolver = Revolver;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Juego{" + "Revolver=" + revolver + ", jugadores=" + jugadores + '}';
    }
    


}
