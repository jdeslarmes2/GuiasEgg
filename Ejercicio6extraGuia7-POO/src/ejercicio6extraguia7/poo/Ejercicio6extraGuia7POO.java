/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6extraguia7.poo;

import Entidades.Ahorcado;
import Servicios.AhorcadoServicio;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio6extraGuia7POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
       Scanner leer = new Scanner(System.in);
       AhorcadoServicio as = new AhorcadoServicio();  
       
      as.crearJuego();
      as.juego();
    }

}
    

