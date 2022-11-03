/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Alquiler;
import entidades.Barco;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class servicioAlquiler {
    
    
    Scanner leer = new Scanner(System.in);
    servicioBarco sb = new servicioBarco();
    Alquiler al = new Alquiler();
    Barco b1 = new Barco();

    
    public Alquiler crearAlquiler(){
        
        Barco b1 = sb.crearBarco();
        System.out.println("Ingrese su nombre: ");
        al.setNombre(leer.next());
        System.out.println("Ingrese su documento: ");
        al.setDocumento(leer.next());
        System.out.println("Ingrese la fecha de inicio del alquiler en formato YYYY-MM-DD: ");
        al.setFechaAlquiler(leer.next());
        System.out.println("Ingrese la fecha de finalización del alquiler en formato YYYY-MM-DD: ");
        al.setFechaDevolucion(leer.next());
        System.out.println("Ingrese el número de la posición de amarre: ");
        al.setPosicionAmarre(leer.nextByte());
        al.setBarco(b1);
        return al;
    }
    
    
}
