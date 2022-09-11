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
public class Fraccion {
    
    private int numeradorFreacción1;
    private int denominadorFreacción1;
    private int numeradorFraccion2;
    private int denominadorFraccion2;

    public Fraccion() {
    }

    public Fraccion(int numeradorFreacción1, int denominadorFreacción1, int numeradorFraccion2, int denominadorFraccion2) {
        this.numeradorFreacción1 = numeradorFreacción1;
        this.denominadorFreacción1 = denominadorFreacción1;
        this.numeradorFraccion2 = numeradorFraccion2;
        this.denominadorFraccion2 = denominadorFraccion2;
    }

    public int getNumeradorFreacción1() {
        return numeradorFreacción1;
    }

    public void setNumeradorFreacción1(int numeradorFreacción1) {
        this.numeradorFreacción1 = numeradorFreacción1;
    }

    public int getDenominadorFreacción1() {
        return denominadorFreacción1;
    }

    public void setDenominadorFreacción1(int denominadorFreacción1) {
        this.denominadorFreacción1 = denominadorFreacción1;
    }

    public int getNumeradorFraccion2() {
        return numeradorFraccion2;
    }

    public void setNumeradorFraccion2(int numeradorFraccion2) {
        this.numeradorFraccion2 = numeradorFraccion2;
    }

    public int getDenominadorFraccion2() {
        return denominadorFraccion2;
    }

    public void setDenominadorFraccion2(int denominadorFraccion2) {
        this.denominadorFraccion2 = denominadorFraccion2;
    }

    @Override
    public String toString() {
        return "Fraccion{" + "numeradorFreacci\u00f3n1=" + numeradorFreacción1 + ", denominadorFreacci\u00f3n1=" + denominadorFreacción1 + ", numeradorFraccion2=" + numeradorFraccion2 + ", denominadorFraccion2=" + denominadorFraccion2 + '}';
    }
    
    
    
    
    
    
}
