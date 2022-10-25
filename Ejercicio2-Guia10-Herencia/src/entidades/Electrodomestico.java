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
public class Electrodomestico {
    
    Scanner leer = new Scanner(System.in);
    
    protected Double precio;
    protected String color;
    protected char consumoEnergetico;
    protected int peso;

    public Electrodomestico() {
    }

    public Electrodomestico(Double precio, String color, char consumoEnergetico, int peso) {
        this.precio = precio;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
    }

    public Scanner getLeer() {
        return leer;
    }

    public void setLeer(Scanner leer) {
        this.leer = leer;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" + "leer=" + leer + ", precio=" + precio + ", color=" + color + ", consumoEnergetico=" + consumoEnergetico + ", peso=" + peso + '}';
    }
    
    
    
    
    public char comprobarConsumoEnergetico (char letra){
        
        String letra1 = String.valueOf(letra);
        if (!letra1.equalsIgnoreCase("A")|| !letra1.equalsIgnoreCase("B")|| !letra1.equalsIgnoreCase("C")|| !letra1.equalsIgnoreCase("D")|| !letra1.equalsIgnoreCase("E")|| !letra1.equalsIgnoreCase("F") ) {
            letra1 = "F";
        }
        char letra2 = letra1.charAt(0);
        return letra2;
    }

      public String comprobarColor (String color){
        
            
        if (!color.equalsIgnoreCase("blanco")|| !color.equalsIgnoreCase("negro")|| !color.equalsIgnoreCase("rojo")|| !color.equalsIgnoreCase("azul")|| !color.equalsIgnoreCase("gris") ) {
            color = "blanco";
        }
        
        return color;
    }
    
    public Electrodomestico crearElectrodomestico(){
        
        Electrodomestico e1 = new Electrodomestico();
        System.out.println("Ingrese el precio del electrodoméstico: ");
        e1.setPrecio(leer.nextDouble());
        System.out.println("Ingrese el color del electrodoméstico: ");
        e1.setColor(leer.next());
        String colorComprobado = comprobarColor(e1.getColor());
        e1.setColor(colorComprobado);
        System.out.println("Ingrese el consumo del electrodoméstico, ranfo (A-F): ");
        e1.setConsumoEnergetico(leer.next().charAt(0));
        char charComprobado = comprobarConsumoEnergetico(e1.getConsumoEnergetico());
        e1.setConsumoEnergetico(charComprobado);
        System.out.println("Ingrese el peso del electrodoméstico: ");
        e1.setPeso(leer.nextInt());
        e1.setPrecio(1000d);
        
        return e1;
    }
    
    public void precioFinal(Electrodomestico e1){
        
        Double preciosConsumo [] = {1000d, 800d, 600d, 500d, 300d, 100d};
        Double preciosPeso [] = {100d, 500d, 800d, 1000d};
      
        String verifChar = String.valueOf(e1.getConsumoEnergetico());
        int verifPeso = e1.getPeso();
                
        if (verifChar.equalsIgnoreCase("A")){
            e1.setPrecio(e1.getPrecio() + preciosConsumo[0]);
        }if (verifChar.equalsIgnoreCase("B")){
            e1.setPrecio(e1.getPrecio() + preciosConsumo[1]);
        }if (verifChar.equalsIgnoreCase("C")){
            e1.setPrecio(e1.getPrecio() + preciosConsumo[2]);
        }if (verifChar.equalsIgnoreCase("D")){
            e1.setPrecio(e1.getPrecio() + preciosConsumo[3]);
        }if (verifChar.equalsIgnoreCase("E")){
            e1.setPrecio(e1.getPrecio() + preciosConsumo[4]);  
        }if (verifChar.equalsIgnoreCase("F")){
            e1.setPrecio(e1.getPrecio() + preciosConsumo[5]);
        }if (verifPeso > 1 && verifPeso <= 19 ){
            e1.setPrecio(e1.getPrecio() + preciosPeso[0]);
        }if (verifPeso > 19 && verifPeso <= 49 ){
            e1.setPrecio(e1.getPrecio() + preciosPeso[1]);
        }if (verifPeso > 49 && verifPeso <= 79 ){
            e1.setPrecio(e1.getPrecio() + preciosPeso[2]);
        }if (verifPeso > 80 ){
            e1.setPrecio(e1.getPrecio() + preciosPeso[3]);
        }
        
    }  
        
        
        
}
