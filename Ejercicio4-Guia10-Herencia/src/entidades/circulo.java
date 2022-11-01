/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import interfaces.calculosFormas;

/**
 *
 * @author jdeslarmes
 */
public class circulo implements calculosFormas{
    
    private double radio;

    public circulo() {
    }

    public circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("");
        System.out.println("El perímetro de su círculo es: "+ PI * (radio *2) + " cms");
        System.out.println("");
    }

    @Override
    public void caluclarArea() {
        System.out.println("");
        System.out.println("El área de su círculo es: "+ PI * radio * radio +" cm2");
        System.out.println("");
    }



}
