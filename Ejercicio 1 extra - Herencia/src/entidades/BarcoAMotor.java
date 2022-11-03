/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public final class BarcoAMotor extends Barco {
    
    Scanner leer = new Scanner(System.in);
    protected int potencia;

    public BarcoAMotor() {
    }

    
    
    public BarcoAMotor(int matricula, int eslora, int anoFabricacion, String nombre, String documento, String fechaAlquiler, String fechaDevolucion, int posicionAmarre, Barco barco) {
        super(matricula, eslora, anoFabricacion, nombre, documento, fechaAlquiler, fechaDevolucion, posicionAmarre, barco);
    }



    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    public int calcularAlquiler(Alquiler alq){
        
        System.out.println("Ingrese la potencia en CV: ");
        this.setPotencia(leer.nextInt());
        int ocupacion = super.calcularAlquiler(alq) / (10 * alq.getBarco().getEslora());
        int alquilerBarcoAMotor = ocupacion * ((10 * alq.getBarco().getEslora()) + this.getPotencia());
        
        return alquilerBarcoAMotor;
    }
    
}
