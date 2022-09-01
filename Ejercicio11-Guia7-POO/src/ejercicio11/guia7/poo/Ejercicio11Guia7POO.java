/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11.guia7.poo;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio11Guia7POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
  

        System.out.println("Ingrese el día: ");
        int dia = leer.nextInt();
        System.out.println("Ingrese el mes: ");
        int mes = leer.nextInt()-1;
        System.out.println("Ingrese el año: ");
        int anio = leer.nextInt();
        Date fecha = new Date(anio-1900,mes,dia);
        Date fechaActual = new Date();
          
        //System.out.println("Su fecha ingresada es día: "+ fecha.getDay()+ " mes: "+ fecha.getMonth()+ " año: "+fecha.getYear());
        System.out.println(fecha);
       
        int diferencia = fechaActual.getYear() - fecha.getYear();
        
        System.out.println("La diferencia de años entre la fecha actual y la cargada es: " + diferencia);
    }

}
