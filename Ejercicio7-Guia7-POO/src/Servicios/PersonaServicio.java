/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Persona;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class PersonaServicio {
    
    Scanner leer = new Scanner (System.in);
    
    //Método crear persona
    
    public Persona crearPersona(){
        
        Persona p1 = new Persona();
        
        System.out.println("Ingrese el nombre: ");
        p1.setNombre(leer.next());
        System.out.println("Ingrese la edad: ");
        p1.setEdad(leer.nextInt());
        System.out.println("Ingrese el sexo (M)/(F)/(O): ");
        p1.setSexo(leer.next());
        while (!(p1.getSexo().equals("M") || p1.getSexo().equals("F") || p1.getSexo().equals("O") )){
            System.out.println("Ingrese nuevamente el sexo (M)/(F)/(O): ");
           p1.setSexo(leer.nextLine());
        } 
        System.out.println("Ingrese el peso en Kg sin decimales");
        p1.setPeso(leer.nextInt());
        System.out.println("Ingrese la altura en mts");
        p1.setAltura(leer.nextDouble());

        return p1;         
        
    }
    
    public int calcularMC(Persona p1){
    

    Double resultado = p1.getPeso()/(p1.getAltura()*p1.getAltura());
    
    if (resultado < 20.0){
        
        return -1;
    } if (resultado < 25.0 & resultado > 20.0){

        return 0;
    }else
            
        return 1;
    }
    
    public Boolean esMayorDeEdad(Persona p1){
    
        if(p1.getEdad() > 17){
        return true;
        } else
        return false;
    }
    
}
