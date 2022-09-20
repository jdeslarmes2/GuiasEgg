/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1extraguia7.pkg2.poo;

import Entidades.Fraccion;
import Servicios.FraccionServicio;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio1extraGuia72POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner leer = new Scanner(System.in);
        
        FraccionServicio fs = new FraccionServicio();
        
        Fraccion f = fs.crearFracciones();
        
        int operacion = 0;
        do {
         
        System.out.println("---------------MENU----------------");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. Division");
        System.out.println("5. Salir");
        System.out.println("Ingrese la operación que desea realizar con las fracciones: ");
        operacion = leer.nextInt();
        
          switch(operacion){
              case 1:
                  fs.sumarFracciones(f);
                  break;
              case 2:
                  fs.restaFracciones(f);
                  break;
              case 3:
                  fs.multiplicacionFracciones(f);
                  break;
              case 4:
                  fs.divisionFracciones(f);
                  break;
              case 5:
                  System.out.println("Gracias por usar la calculadora");
                  break;
            } 
        } while (operacion!=5);  

}
}
