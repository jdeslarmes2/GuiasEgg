/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author jdeslarmes
 */
public class Juego {
    
    private int numAdivinar;
    private int numElegido;

    public Juego() {
    }

    public Juego(int numAdivinar, int numElegido) {
        this.numAdivinar = numAdivinar;
        this.numElegido = numElegido;
    }

    public int getNumAdivinar() {
        return numAdivinar;
    }

    public void setNumAdivinar(int numAdivinar) {
        this.numAdivinar = numAdivinar;
    }

    public int getNumElegido() {
        return numElegido;
    }

    public void setNumElegido(int numElegido) {
        this.numElegido = numElegido;
    }

    @Override
    public String toString() {
        return "Juego{" + "numAdivinar=" + numAdivinar + ", numElegido=" + numElegido + '}';
    }
    
    
    
    
    
}
