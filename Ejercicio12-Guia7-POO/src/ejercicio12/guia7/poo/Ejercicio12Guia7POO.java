/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12.guia7.poo;

import Entidades.Persona;
import Servicios.PersonaServicio;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio12Guia7POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        Scanner leer = new Scanner(System.in);
             //Instaciar un objeto de tipo Servicio
             
             PersonaServicio ps1 = new PersonaServicio();

             
             //Intanciación del objeto donde alojar el retorno de datos
             
             Persona p1 = new Persona(); 
             p1 = ps1.crearPersona();
             
                int operacion = 0;
       
       do {
            System.out.println("|1.Calcular edad de persona                  |");
            System.out.println("|2.Verificar si edad de persona es  menor que|");
            System.out.println("|3.Mostrar persona                           |");
            System.out.println("|4.salir             |");
            System.out.println("Ingrese la operación que desea realizar: ");
            operacion = leer.nextInt();
           
              switch(operacion){
                case 1:
                    ps1.calcularEdad();
                    break;
                case 2:
                    System.out.println("Ingrese la edad a verificar");
                   
                    if (ps1.menorQue(leer.nextInt())== true){
                        System.out.println("Edad mayor a la de la persona");
                    } else {
                        System.out.println("Edad es menor a la de la persona");
                    }
                    break;
                case 3:
                    System.out.println(ps1.mostrarPersona());
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;
                }
         } while (operacion != 4);
       
       
}
}
             
             
             
             
             
