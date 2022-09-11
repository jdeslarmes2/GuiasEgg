/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author jdeslarmes
 */
public class Ahorcado {
    private String [] palabra;
    private int cantidadLetras;
    private int cantidadJugadasMax;
    private int oportunidades;

    public Ahorcado() {
    }

    public Ahorcado(String[] palabra, int cantidadLetras, int cantidadJugadasMax) {
        this.palabra = palabra;
        this.cantidadLetras = cantidadLetras;
        this.cantidadJugadasMax = cantidadJugadasMax;
    }

    public String[] getPalabra() {
        return palabra;
    }

    public void setPalabra(String[] palabra) {
        this.palabra = palabra;
    }

    public int getCantidadLetras() {
        return cantidadLetras;
    }

    public void setCantidadLetras(int cantidadLetras) {
        this.cantidadLetras = cantidadLetras;
    }

    public int getCantidadJugadasMax() {
        return cantidadJugadasMax;
    }

    public void setCantidadJugadasMax(int cantidadJugadasMax) {
        this.cantidadJugadasMax = cantidadJugadasMax;
    }

    @Override
    public String toString() {
        return "Ahorcado{" + "palabra=" + palabra + ", cantidadLetras=" + cantidadLetras + ", cantidadJugadasMax=" + cantidadJugadasMax + '}';
    }

    public int getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(int oportunidades) {
        this.oportunidades = oportunidades;
    }
    
    
    
    
}
