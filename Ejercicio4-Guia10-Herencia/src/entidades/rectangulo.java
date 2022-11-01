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
public class rectangulo implements calculosFormas{
    
   private double base;
   private double altura;
   
    public rectangulo() {
    }

    public rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("");
        System.out.println("El perímetro del rectángulo es: "+ (base + altura) * 2 + " cms");
        System.out.println("");
    }

    @Override
    public void caluclarArea() {
        System.out.println("");
        System.out.println("El área del rectangulo es: "+ base * altura + " cm2");
        System.out.println("");
    }


    
    
}
