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
public class Baraja {
    
    private ArrayList <Carta> cartas; 
    private ArrayList <Carta> cartasEntregadas;

    public Baraja() {
    }

    public Baraja(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<Carta> getCartasEntregadas() {
        return cartasEntregadas;
    }

    public void setCartasEntregadas(ArrayList<Carta> cartasEntregadas) {
        this.cartasEntregadas = cartasEntregadas;
    }

    @Override
    public String toString() {
        return "Baraja{" + "cartas=" + cartas + ", cartasEntregadas=" + cartasEntregadas + '}';
    }


}