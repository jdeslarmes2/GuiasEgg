/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Scanner;






public class Electrodomestico {
    

        
    protected Double precio;
    protected String color;
    protected char consumoEnergetico;
    protected int peso;
    

    Scanner leer = new Scanner(System.in);
    
    
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
        if (!(letra1.equals("A")|| letra1.equals("B")|| letra1.equals("C")|| letra1.equals("D")|| letra1.equals("E")|| letra1.equals("F")) ) {
            letra1 = "F";
        }
        char letra2 = letra1.charAt(0);
        return letra2;
    }

      public String comprobarColor (String color){
        
            
        if (!(color.equalsIgnoreCase("blanco")|| color.equalsIgnoreCase("negro")|| color.equalsIgnoreCase("rojo")|| color.equalsIgnoreCase("azul")|| color.equalsIgnoreCase("gris")) ) {
            color = "blanco";
        }
        
        return color;
    }
    
    public void crearElectrodomestico(){
        
       
        
        System.out.println("Ingrese el color del electrodoméstico: ");
        this.setColor(leer.next());
        String colorComprobado = comprobarColor(this.getColor());
        this.setColor(colorComprobado);
        System.out.println("Ingrese el consumo del electrodoméstico, ranfo (A-F): ");
        this.setConsumoEnergetico(leer.next().charAt(0));
        char charComprobado = comprobarConsumoEnergetico(this.getConsumoEnergetico());
        this.setConsumoEnergetico(charComprobado);
        System.out.println("Ingrese el peso del electrodoméstico: ");
        this.setPeso(leer.nextInt());
        this.setPrecio(1000d);
        
    
    }
    
    public void precioFinal(){
        
        Double preciosConsumo [] = {1000d, 800d, 600d, 500d, 300d, 100d};
        Double preciosPeso [] = {100d, 500d, 800d, 1000d};
      
        String verifChar = String.valueOf(this.getConsumoEnergetico());
        int verifPeso = this.getPeso();
                
        if (verifChar.equalsIgnoreCase("A")){
            this.setPrecio(this.getPrecio() + preciosConsumo[0]);
        }if (verifChar.equalsIgnoreCase("B")){
            this.setPrecio(this.getPrecio() + preciosConsumo[1]);
        }if (verifChar.equalsIgnoreCase("C")){
            this.setPrecio(this.getPrecio() + preciosConsumo[2]);
        }if (verifChar.equalsIgnoreCase("D")){
            this.setPrecio(this.getPrecio() + preciosConsumo[3]);
        }if (verifChar.equalsIgnoreCase("E")){
            this.setPrecio(this.getPrecio() + preciosConsumo[4]);  
        }if (verifChar.equalsIgnoreCase("F")){
            this.setPrecio(this.getPrecio() + preciosConsumo[5]);
        }if (verifPeso > 1 && verifPeso <= 19 ){
            this.setPrecio(this.getPrecio() + preciosPeso[0]);
        }if (verifPeso > 19 && verifPeso <= 49 ){
            this.setPrecio(this.getPrecio() + preciosPeso[1]);
        }if (verifPeso > 49 && verifPeso <= 79 ){
            this.setPrecio(this.getPrecio() + preciosPeso[2]);
        }if (verifPeso > 80 ){
            this.setPrecio(this.getPrecio() + preciosPeso[3]);
        }
        
    }  
        
        
        
}
