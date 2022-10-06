/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.guia9.relaciones;

import entidades.Perro;
import entidades.Persona;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio1Guia9Relaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        Perro perro1 = new Perro();
        perro1.setNombre("Bichi");
        perro1.setRaza("Border");
        perro1.setEdad(6);
        perro1.setTamano(2);
        
        Persona persona1 = new Persona();
        persona1.setNombre("Jose");
        persona1.setApellido("Gomez");
        persona1.setDocumento(9456789);
        persona1.setPerro(perro1);    //Configuramos el perro 1 para la persona 1
         
        Perro perro2 = new Perro();
        perro2.setNombre("Cato");
        perro2.setRaza("Chiguagua");
        perro2.setEdad(3);
        perro2.setTamano(1);

        
        Persona persona2 = new Persona();
        persona2.setNombre("Federico");
        persona2.setApellido("Lopez");
        persona2.setDocumento(30786432);
        persona2.setPerro(perro2);      //Configuramos el perro 2 para la persona 2
        
        System.out.println("Los datos de la persona 1 son: " + persona1.toString() +",\nEl perro de la persona1 es: " + perro1.toString()+ ",\nLos datos de la persona 2 son : "+ persona2.toString() +",\nEl perro de la persona 2 es: "+ perro2.toString());
        
        
    }
    
}
