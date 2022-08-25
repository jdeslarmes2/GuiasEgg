/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.guia7.poo;

import Entidades.Persona;
import Servicios.PersonaServicio;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio7Guia7POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             Scanner leer = new Scanner(System.in);
     
     Double sobrepeso = 0.0;
     Double ideal = 0.0;
     Double menospeso = 0.0; 
     Double menor = 0.0;
     Double mayor =0.0;
                
             
             //Instaciar un objeto de tipo Servicio
             
             PersonaServicio ps1 = new PersonaServicio();

             
             //Intanciación del objeto donde alojar el retorno de datos
             
             Persona p1 = ps1.crearPersona();
             
             //Calculo si esta dentro del peso ideal la persona 1
             if(ps1.calcularMC(p1) == -1){
                menospeso += 1 ;
               }if (ps1.calcularMC(p1) == 0){
                ideal += 1 ;
               }if (ps1.calcularMC(p1) == 1){   
                sobrepeso += 1 ;
             }   
             //Calculo si es mayor de edad la persona 1  
             if(ps1.esMayorDeEdad(p1)){
                 mayor += 1;
             } else {
                 menor += 1;
             }
             
            Persona p2 = ps1.crearPersona();

              //Calculo si esta dentro del peso ideal la persona 2
            if(ps1.calcularMC(p2) == -1){
                menospeso += 1 ;
               }if (ps1.calcularMC(p2) == 0){
                ideal += 1 ;
               } if (ps1.calcularMC(p2) == 1){   
                sobrepeso += 1 ;
               }     
               //Calculo si es mayor de edad la persona 2
              if(ps1.esMayorDeEdad(p2)){
                 mayor += 1;
             } else {
                 menor += 1;
             }
                     

             Persona p3 = ps1.crearPersona();
             
             //Calculo si esta dentro del peso ideal la persona 3
              if(ps1.calcularMC(p3) == -1){
                menospeso += 1 ;
               }if (ps1.calcularMC(p3) == 0){
                ideal += 1 ;
               } if (ps1.calcularMC(p3) == 1){   
                sobrepeso += 1 ;
             }        
             
             //Calculo si es mayor de edad la persona 3
              if(ps1.esMayorDeEdad(p3)){
                 mayor += 1;
             } else {
                 menor += 1;
             }
             
             Persona p4 = ps1.crearPersona();

             //Calculo si esta dentro del peso ideal la persona 4
             if(ps1.calcularMC(p4) == -1){
                menospeso += 1 ;
               }if (ps1.calcularMC(p4) == 0){
                ideal += 1 ;
               } if (ps1.calcularMC(p4) == 1){   
                sobrepeso += 1 ;
             } 
            //Calculo si es mayor de edad la persona 4
              if(ps1.esMayorDeEdad(p4)){
                 mayor += 1;
             } else {
                 menor += 1;
             }
            
            Double menorPeso = ( menospeso / 4 )*100;
            Double idealPeso = ( ideal / 4 )*100;
            Double sobrePeso = ( sobrepeso / 4 )*100;
            Double mayorEdad = ( mayor / 4 )*100;
            Double menorEdad = ( menor / 4 )*100;
     
              
            System.out.println("El porcentaje de personas con menor peso del ideal es: % " + menorPeso  );
            System.out.println("El porcentaje de personas con peso ideal es: % " +  idealPeso );
            System.out.println("El porcentaje de personas con sobrepeso es: % " +  sobrePeso );
            System.out.println("El porcentaje de personas mayores es: % " +  mayorEdad );
            System.out.println("El porcentaje de personas menores es: % " +  (menor /4)*100 );
     
     
}
     
}     
     
     