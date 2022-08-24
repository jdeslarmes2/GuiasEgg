/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6.guia7.poo;

import Entidades.Cafetera;
import Servicios.CafeteraServicio;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio6Guia7POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner leer = new Scanner(System.in);

       //Instaciar un objeto de tipo Servicio
       
       CafeteraServicio cs = new CafeteraServicio();
       
       //Intanciación del objeto donde alojar el retorno de la Cuenta
       
       Cafetera c1 = cs.crearCafetera();
       
       int operacion = 0;
       
       do {
            System.out.println("|1.Completar cafetera|");
            System.out.println("|2.Llenar taza       |");
            System.out.println("|3.Vaciar cafetera   |");
            System.out.println("|4.Agregar cafe      |");
            System.out.println("|5.Salir             |");   
            System.out.println("Ingrese la operación que desea realizar: ");
            operacion = leer.nextInt();
           
              switch(operacion){
                case 1:
                    cs.llenarCafetera(c1);
                    break;
                case 2:
                    cs.llenarTaza(c1);
                    break;
                case 3:
                    cs.vaciarCafetera(c1);
                    break;
                case 4:
                    cs.agregarCafe(c1);
                    break;
                case 5:
                    System.out.println("Gracias por usar Nespresso");
                    break;
                }
         } while (operacion != 5);
       
       
}
}
    
    

