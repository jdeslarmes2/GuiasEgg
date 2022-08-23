/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.Scanner;
import poo3.operacion;
/**
 *
 * @author Skais
 */
public class Ejercicio3 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("defina los dos numeros de la operacion");
        
        //int num1 = leer.nextInt();
        //int num2 = leer.nextInt();
        operacion numer = new operacion();
        numer.crearOperacion();
        int oper=0;
        while(oper != 6){
            System.out.println("calculadora x----");
            System.out.println(".---------------.");
            System.out.println("|1.sumar        |");
            System.out.println("|2.restar       |");
            System.out.println("|3.multiplicar  |");
            System.out.println("|4.dividir      |");
            System.out.println("|5.definir valor|");
            System.out.println("|6.salir        |");
            System.out.println("| Elija opcion: |");
            System.out.println(".---------------.");
            oper = leer.nextInt();
            switch(oper){
                case 1:
                    numer.sumar();
                    break;
                case 2:
                    numer.restar();
                    break;
                case 3:
                    numer.multiplicar();
                    break;
                case 4:
                    numer.Dividir();
                    break;
                case 5:
                    numer.crearOperacion();
                    break;
                case 6:
                    System.out.println("gracias por estar con nosotros");
                    break;
            }
        
        }
    }
    
}
