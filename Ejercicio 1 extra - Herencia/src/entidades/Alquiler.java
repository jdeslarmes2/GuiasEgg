/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
/**
 *
 * @author jdeslarmes
 */
public class Alquiler {
    
    protected String nombre;
    protected String documento;
    protected String fechaAlquiler;
    protected String fechaDevolucion;
    protected int posicionAmarre;
    public Barco barco;

    public Alquiler() {
    }

    public Alquiler(String nombre, String documento, String fechaAlquiler, String fechaDevolucion, int posicionAmarre, Barco barco) {
        this.nombre = nombre;
        this.documento = documento;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getPosicionAmarre() {
        return posicionAmarre;
    }

    public void setPosicionAmarre(int posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    
    public int calcularAlquiler(Alquiler alq){
    
         System.out.println(alq.getFechaAlquiler());
         System.out.println(alq.getFechaDevolucion());
         //Parsing the date 
         LocalDate dateBefore = LocalDate.parse(alq.getFechaAlquiler());
         LocalDate dateAfter = LocalDate.parse(alq.getFechaDevolucion()); 
         //calculating number of days in between 
         long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
         int ocupacion = (int)noOfDaysBetween;
        //displaying the number of days 
        System.out.println("El número de días de alquiler es: " + noOfDaysBetween);  
        //calculating rental
        int alquiler = ocupacion * 10 * alq.getBarco().getEslora();
        
        return alquiler;
                
                
                
                
    }
    
    
    
    
}
