/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9.guia7.poo;

import Entidades.Matematicas;
import Servicios.MatematicasServicio;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio9Guia7POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Scanner leer = new Scanner(System.in);
        
        MatematicasServicio ms = new MatematicasServicio();
        
        Matematicas m1 = ms.crearObjeto();
        
        ms.devolverMayor(m1);
        ms.calcularPotencia(m1);
        ms.calcularRaiz(m1);
    }
    
}
