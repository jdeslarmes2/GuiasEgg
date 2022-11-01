/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4.guia10.herencia;

import entidades.circulo;
import entidades.rectangulo;
import servicios.servicioCirculo;
import servicios.servicioRectangulo;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio4Guia10Herencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        servicioCirculo sc = new servicioCirculo();
        servicioRectangulo sr = new servicioRectangulo();
        
        rectangulo rec = sr.crearRectangulo();
        circulo cir = sc.crearCirculo();
        
        rec.calcularPerimetro();
        rec.caluclarArea();
        
        cir.calcularPerimetro();
        cir.caluclarArea();
        
        
    }
    
}
