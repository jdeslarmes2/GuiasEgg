/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Lavadora extends Electrodomestico{
    
    private int carga;

    
    
    public Lavadora() {
    }


    public Lavadora(int carga, Double precio, String color, char consumoEnergetico, int peso) {
        super(precio, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    
    public void crearLavadora(){
        System.out.println("");
        System.out.println("-----------------Creando Lavadora------------");
        System.out.println("");
        super.crearElectrodomestico();
        System.out.println("Ingrese el valor de carga de la lavadora: ");
        this.setCarga(leer.nextInt());
        this.setColor(color);
        this.setPrecio(precio);
        this.setConsumoEnergetico(consumoEnergetico);
        this.setPeso(peso);

    }
    
    public void precioFinal (){
       
       super.precioFinal();
       if (this.getCarga() > 30 ){
           this.setPrecio(this.getPrecio() + 500);
       } 
        
    }
    
    
    
    
}
