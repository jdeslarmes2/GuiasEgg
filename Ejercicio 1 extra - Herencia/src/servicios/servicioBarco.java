/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;


import entidades.Barco;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class servicioBarco {

Scanner leer = new Scanner(System.in);

Barco bar = new Barco();

public Barco crearBarco(){
    
    System.out.println("Ingrese el número de matrícula de su barco: ");
    bar.setMatricula(leer.nextInt());
    System.out.println("Ingrese la eslora en mts: ");
    bar.setEslora(leer.nextInt());
    System.out.println("Ingrese el año de fabricación de su barco: ");
    bar.setAnoFabricacion(leer.nextInt());
    
    return bar;
}


    
}
