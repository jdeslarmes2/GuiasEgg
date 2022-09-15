/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidades.Meses;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class MesesServicio {
 
    Scanner leer = new Scanner(System.in);
    
    Meses m1 = new Meses();
    
    public void crearConsulta(){
        
        System.out.println("Ingrese el mes que elige para adivinar: ");
        m1.setMesElegido(leer.next());
    //    int i =0;
        for (int i=0; i<2; i++){
            if (m1.getMesElegido().equals(m1.getMesSecreto())){
            System.out.println("¡Ha acertado!"); 
            break;
            } else {
            System.out.println("No ha acertado. Intente nuevamente introduciendo otro mes: ");
            m1.setMesElegido(leer.next());
            }
        } 
        System.out.println("Se finalizo la consulta");
    }
                
} 
    

