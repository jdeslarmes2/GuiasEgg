/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.RevolverDeAgua;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class ServicioRevolverDeAgua {
    
    Scanner leer = new Scanner(System.in);
    
    RevolverDeAgua ra = new RevolverDeAgua();
    
    
    public static int generarNumeroAleatorio (int minimo, int maximo) {
    int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
    return num;
    }
    
    public RevolverDeAgua llenarRevolver(){

        ra.setPosicionActual(generarNumeroAleatorio(1, 6));
        ra.setPosicionAgua(generarNumeroAleatorio(1, 6));
        return ra;
        
    }
 
    public boolean mojar(RevolverDeAgua r){
        
        boolean respuesta = false;
        if (r.getPosicionActual() == r.getPosicionAgua()){
            respuesta = true;
        }
        return respuesta;
    }
    
    public void siguienteChorro(RevolverDeAgua r){
        
        int posicion = r.getPosicionActual();
        if(posicion==6){
            r.setPosicionActual(1);
        }else {
           posicion++;
           r.setPosicionActual(posicion);
        }
    }
    
    public void mostrarRevolver(RevolverDeAgua r){
        
        System.out.println("La posición actual del tambor que se dispara: " + r.getPosicionActual());
        System.out.println("La posición actual del tabor con el agua: "+ r.getPosicionAgua());
        
    }    
    
    
    
}
