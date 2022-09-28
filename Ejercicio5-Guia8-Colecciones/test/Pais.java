/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5.g8.entidades;

/**
 *
 * @author jdeslarmes
 */
public class Pais implements Comparable<String>{
   // 
    private String nombre;

    public Pais() {
    }

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + '}';
    }

   // @Override
   // public int compareTo(Pais t) {
   //     return this.nombre.compareTo(t.getNombre());
   // }

    @Override
    public int compareTo(String t) {
         return t.compareTo(this.nombre);
    }
    
    
    
}
