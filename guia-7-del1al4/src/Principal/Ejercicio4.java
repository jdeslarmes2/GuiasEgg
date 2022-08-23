/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import java.util.Scanner;
import poo4.rectangulo;
/**
 *
 * @author Skais
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("defina los dos valores de las operaciones");
        
        //int num1 = leer.nextInt();
        //int num2 = leer.nextInt();
        rectangulo numer = new rectangulo();
        numer.crearOperacion();
        int oper=0;
        while(oper != 5){
            System.out.println("calculadora x----");
            System.out.println(".---------------.");
            System.out.println("|1.perimetro    |");
            System.out.println("|2.superficie   |");
            System.out.println("|3.dibujo       |");
            System.out.println("|4.definir valor|");
            System.out.println("|5.salir        |");
            System.out.println("|6.Extra        |");
            System.out.println("| Elija opcion: |");
            System.out.println(".---------------.");
            oper = leer.nextInt();
            switch(oper){
                case 1:
                    numer.calcularPerímetro();
                    break;
                case 2:
                    numer.calcularSuperficie();
                    break;
                case 3:
                    numer.dibujar();
                    break;
                case 4:
                    numer.crearOperacion();
                    break;
                case 5:
                    System.out.println("gracias por estar con nosotros");
                    break;
                case 6:
                    System.out.println("y ya enserio... cual es tu DNI?");
                    System.out.println(" ");
                    System.out.println("rectangulo:...");
                    break;    
            }
        
        }

    }
    
}
