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
public final class Velero extends Barco {
    
    
   Scanner leer = new Scanner(System.in);
    protected int mastiles;

    public Velero() {
    }

    
    
    public Velero(int matricula, int eslora, int anoFabricacion, String nombre, String documento, String fechaAlquiler, String fechaDevolucion, int posicionAmarre, Barco barco) {
        super(matricula, eslora, anoFabricacion, nombre, documento, fechaAlquiler, fechaDevolucion, posicionAmarre, barco);
    }

   
    public int getMastiles() {
        return mastiles;
    }

    public void setMastiles(int mastiles) {
        this.mastiles = mastiles;
    }

   
    public int calcularAlquiler(Alquiler alq){
        
        System.out.println("Ingrese el número de mastiles: ");
        this.setMastiles(leer.nextInt());
        int ocupacion = super.calcularAlquiler(alq) / (10 * alq.getBarco().getEslora());
        int alquilerVelero = ocupacion * ((10 * alq.getBarco().getEslora()) + this.getMastiles());
        
        return alquilerVelero;
    }
}
