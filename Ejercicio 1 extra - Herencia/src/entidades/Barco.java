/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author jdeslarmes
 */
public class Barco extends Alquiler {
    
    protected int matricula;
    protected int eslora;
    protected int anoFabricacion;

    public Barco() {
    }
    
    

    public Barco(int matricula, int eslora, int anoFabricacion, String nombre, String documento, String fechaAlquiler, String fechaDevolucion, int posicionAmarre, Barco barco) {
        super(nombre, documento, fechaAlquiler, fechaDevolucion, posicionAmarre, barco);
        this.matricula = matricula;
        this.eslora = eslora;
        this.anoFabricacion = anoFabricacion;
    }

  

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getEslora() {
        return eslora;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }
    

    
    
    
}
