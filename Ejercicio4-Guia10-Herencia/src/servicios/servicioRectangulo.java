/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.rectangulo;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class servicioRectangulo {
    
    Scanner leer = new Scanner(System.in);
    
    rectangulo rec = new rectangulo();
    
    
    public rectangulo crearRectangulo(){
        
        System.out.println("Ingerese la base del rectángulo en cms: ");
        rec.setBase(leer.nextDouble());
        System.out.println("Ingrese la altura del rectángulo en cms: ");
        rec.setAltura(leer.nextDouble());
        
        return rec;
    }
    
}
