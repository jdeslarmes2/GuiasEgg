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
public class NIF {
    
    private int numeroDNI;
    private String letra;

    public NIF() {
    }

    public NIF(int numeroDNI, String letra) {
        this.numeroDNI = numeroDNI;
        this.letra = letra;
    }

    public int getNumeroDNI() {
        return numeroDNI;
    }

    public void setNumeroDNI(int numeroDNI) {
        this.numeroDNI = numeroDNI;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Override
    public String toString() {
        return "NIF{" + "numeroDNI=" + numeroDNI + ", letra=" + letra + '}';
    }
    
    
}
