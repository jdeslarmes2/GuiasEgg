/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.circulo;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class servicioCirculo {
    
    Scanner leer = new Scanner(System.in);
    
    circulo cir = new circulo();
    
    
    public circulo crearCirculo(){
        
        System.out.println("Ingrese el radio del círculo en cms: ");
        cir.setRadio(leer.nextDouble());
        
        return cir;
    }
    
    
}
