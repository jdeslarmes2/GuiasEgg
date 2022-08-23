/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Cuenta;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class CuentaServicio {
    Scanner leer = new Scanner (System.in);
    
    public Cuenta crearCuenta(){
    
        //Instanciar un objeto de tipo cuenta
        
       Cuenta c1 = new Cuenta();
       
       //Completo los atributos
        
        System.out.println("Ingrese el número de cuenta");
        c1.setNumeroCuenta(leer.nextInt());
        System.out.println("Ingrese el número de dni");
        c1.setDni(leer.nextInt());
        System.out.println("Ingrese el saldo actual de la cuenta");
        c1.setSaldoActual(leer.nextDouble());
        
        return c1;
        
    }
    
    //Método de ingreso de dinero
        public void ingresarDinero(Cuenta c1){
            System.out.println("Ingrese el dinero que quiere ingresar");
            Double dineroIngresado = leer.nextDouble(); 
            c1.setSaldoActual(c1.getSaldoActual() + dineroIngresado);
            System.out.println("Su saldo actual es: " + c1.getSaldoActual());
    }
    
    // Método de retiro de dinero
        public void retirarDinero(Cuenta c1){
           System.out.println("Ingrese el dinero que quiere retirar");
            Double dineroRetirar = leer.nextDouble();  
            
            if(dineroRetirar > c1.getSaldoActual()){
                c1.setSaldoActual(0.0);   
            } else
               c1.setSaldoActual(c1.getSaldoActual() - dineroRetirar); 
            System.out.println("Su saldo actual es: "+ c1.getSaldoActual());
        }
         
     // Método extracción Rápida 
        public void extraccionRapida(Cuenta c1){
            System.out.println("Ingrese el dinero que quiere retirar");
            Double dineroRetirar = leer.nextDouble(); 
            
             if(dineroRetirar > c1.getSaldoActual()*0.2){
                 System.out.println("Su saldo actual es de: $" + c1.getSaldoActual() + ", no puede retirar más del 20% de su saldo: $" + c1.getSaldoActual()* 0.2);    
             } else
                 c1.setSaldoActual(c1.getSaldoActual() - dineroRetirar);
                 System.out.println("Su saldo actual es: " + c1.getSaldoActual());
        }    
        
        //Método consultar saldo
        public void consultarSaldo(Cuenta c1){
            System.out.println("Su saldo actual es: " + c1.getSaldoActual());
        }
        
        //Método consultar datos
        
        public void consultarDatos(Cuenta c1){
            System.out.println("El número de cuenta es: " + c1.getNumeroCuenta());
            System.out.println("El número de dni es: " + c1.getDni());
                       
        }
}
        

