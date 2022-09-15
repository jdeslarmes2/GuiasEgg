/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5extra.guia7.pkg2.poo;

import Entidades.triangulo;
import Servicios.trianguloServicio;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio5extraGuia72POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        trianguloServicio ts = new trianguloServicio();
        
        //Triangulo 1
        
        triangulo t1 = ts.crearTriangulo();
        ts.calcularArea(t1);
        ts.calcularPerimetro(t1);
        
        //Triangulo 2
        
        triangulo t2 = ts.crearTriangulo();
        ts.calcularArea(t2);
        ts.calcularPerimetro(t2);
        
         //Triangulo 3
        
        triangulo t3 = ts.crearTriangulo();
        ts.calcularArea(t3);
        ts.calcularPerimetro(t3);
        
         //Triangulo 4

        triangulo t4 = ts.crearTriangulo();
        ts.calcularArea(t4);
        ts.calcularPerimetro(t4);
        
        //Superficie másxima de los cuatro triangulos
        
        ts.mostrarSuperficieMáxima(t1, t2, t3, t4);
        
    }
    
}
