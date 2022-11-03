/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg1.extra.herencia;

import entidades.Alquiler;
import entidades.BarcoAMotor;
import entidades.Velero;
import entidades.Yate;
import java.util.Scanner;
import servicios.servicioAlquiler;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio1ExtraHerencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Scanner leer = new Scanner(System.in);
        Alquiler alquiler = new Alquiler();
        servicioAlquiler sa = new servicioAlquiler();
        Velero velero = new Velero();
        BarcoAMotor barcoMotor = new BarcoAMotor();
        Yate yate = new Yate();
        
        int tipoDeBarco;
        
        //Creo los datos del alquiler y barco
        alquiler = sa.crearAlquiler();
        
        //Calculo el alquiler
        System.out.println("Ingrese el tipo de barco para el que quiere alquilar el amarre (1. Velero, 2. Barco a Motor, 3. Yate, 4. Otros) : ");
        tipoDeBarco = leer.nextInt();
        
        switch (tipoDeBarco){
            
            case 1: 
                System.out.println("");
                System.out.println("El valor del alquiler de su velero es: "+ velero.calcularAlquiler(alquiler) +" $");
                break;
            case 2:
                System.out.println("");
                System.out.println("El valor del alquiler de su barco a motor es: "+ barcoMotor.calcularAlquiler(alquiler) + " $");
                break;
             case 3: 
                System.out.println("");
                System.out.println("El valor del alquiler de su yate es: "+ yate.calcularAlquiler(alquiler) +" $");
                break;
            case 4:
                System.out.println("");
                System.out.println("El valor del alquiler de su barco a motor es: "+ alquiler.calcularAlquiler(alquiler) + " $");     
                break;
            default:
                System.out.println("");
                System.out.println("Su elección fue incorrecta");
                
        }
        
        
        
    }
    
}
