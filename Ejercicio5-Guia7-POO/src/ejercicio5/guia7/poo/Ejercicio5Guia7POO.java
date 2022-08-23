/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5.guia7.poo;

import Entidades.Cuenta;
import Servicios.CuentaServicio;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio5Guia7POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner leer = new Scanner(System.in);

       //Instaciar un objeto de tipo Servicio
       
       CuentaServicio cs = new CuentaServicio();
       
       //Intanciación del objeto donde alojar el retorno de la Cuenta
       
       Cuenta c1 = cs.crearCuenta();
       
       int operacion = 0;
       
       do {
            System.out.println("|1.Ingresar dinero   |");
            System.out.println("|2.Retirar dinero    |");
            System.out.println("|3.Extracción Rápida |");
            System.out.println("|4.Consultar Saldo   |");
            System.out.println("|5.Consultar Datos   |");
            System.out.println("|6.salir             |");
            System.out.println("Ingrese la operación que desea realizar: ");
            operacion = leer.nextInt();
           
              switch(operacion){
                case 1:
                    cs.ingresarDinero(c1);
                    break;
                case 2:
                    cs.retirarDinero(c1);
                    break;
                case 3:
                    cs.extraccionRapida(c1);
                    break;
                case 4:
                    cs.consultarSaldo(c1);
                    break;
                case 5:
                    cs.consultarDatos(c1);
                    break;
                case 6:
                    System.out.println("gracias por estar con nosotros");
                    break;
                }
         } while (operacion != 6);
       
       
}
}