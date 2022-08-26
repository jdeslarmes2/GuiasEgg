/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Persona;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class PersonaServicio {
    
    Scanner leer = new Scanner (System.in);
    
    Persona personaactual = new Persona();
    
    Date fechaactual = new Date();
    
    public Persona crearPersona(){
       
        System.out.println("Ingrese el nombre de la persona");
        personaactual.setNombre(leer.nextLine());
        System.out.println("Ingrese la fecha de nacimiento de " + personaactual.getNombre());
        System.out.println("Ingrese el día: ");
        int dia = leer.nextInt();
        System.out.println("Ingrese el mes: ");
        int mes = leer.nextInt();
        System.out.println("Ingrese el año: ");
        int anio = leer.nextInt();
        Date fecha = new Date(anio-1900,mes-1,dia);
        personaactual.setFechanacimiento(fecha);
        return personaactual;     
    }  
     
    
    public void  calcularEdad(){
       
        System.out.println("La edad de " + personaactual.getNombre()+ "es de: " + (fechaactual.getYear()-personaactual.getFechanacimiento().getYear()));
        
    }
    
    public Boolean menorQue (int nuevaedad){
        boolean condicion;
        int edadpersonaactual = fechaactual.getYear()-personaactual.getFechanacimiento().getYear();
        if (edadpersonaactual < nuevaedad){
            condicion = true;
        }else{
            condicion = false;
        }
        return condicion;
        
        }
    
    
    public String mostrarPersona(){
        
        
        return personaactual.toString();
 
    
        
  }
}