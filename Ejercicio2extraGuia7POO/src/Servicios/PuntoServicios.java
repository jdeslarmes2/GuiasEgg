/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Punto;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class PuntoServicios {
    
    
    Scanner leer = new Scanner(System.in);
    
    
    public Punto crearPuntos(){
        Punto p1 = new Punto();
        System.out.println("Ingrese valores para x1,y1: ");
        p1.setX1(leer.nextInt());
        p1.setY1(leer.nextInt());
        System.out.println("Ingrese valores para x2,y2: ");
        p1.setX2(leer.nextInt());
        p1.setY2(leer.nextInt());
        return p1;
       
    }
    
    public void calcularDistancia(Punto p1){
        Double distancia = Math.sqrt(Math.pow((p1.getX2()-p1.getX1()), 2) + Math.pow((p1.getY2()-p1.getY1()), 2));
        System.out.println("La distancia entre ambos puntos es: "+ distancia);
    }
}
