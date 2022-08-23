/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp.entidades;

/**
 *
 * @author jdeslarmes
 */
public class Mascota {

    public String nombre;
    public String apodo;
    //Conejo, Gato, Perro, Loro, Carpincho
    public String tipo;
    public String color;
    public int edad;
    public boolean cola;
    public String raza;
    
    //Crear constructor
    public Mascota(){
        
    }
    
    public Mascota(String nombre, String apodo, String tipo){
            this.nombre = nombre;
            this.apodo = apodo;
            this.tipo = tipo;
    }

    public Mascota(String nombre, String apodo, String tipo, String color, int edad, boolean cola, String raza) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.tipo = tipo;
        this.color = color;
        this.edad = edad;
        this.cola = cola;
        this.raza = raza;
    }
    
    
}
