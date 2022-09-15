/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.logging.Logger;

/**
 *
 * @author jdeslarmes
 */
public class triangulo {
    
    private Double base;
    private Double altura;
    private Double area;

    public triangulo() {
    }

    public triangulo(Double base, Double altura, Double area) {
        this.base = base;
        this.altura = altura;
        this.area = area;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

}