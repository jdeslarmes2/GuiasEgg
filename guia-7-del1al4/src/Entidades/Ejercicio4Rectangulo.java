/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo4;
import java.util.Scanner;
/**
 *
 * @author Skais
 */
public class Ejercicio4Rectangulo {
    Scanner leer = new Scanner(System.in);
    private int altura;
    private int base;

    public Ejercicio4Rectangulo(int altura, int base) {
        this.altura = altura;
        this.base = base;
    }

    public Ejercicio4Rectangulo() {
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
    public float calcularSuperficie(){
        float resultado = base * altura;
        System.out.println("la superficie es de: " + resultado);
        return resultado;}
    
    public float calcularPerímetro(){
        float resultado = (base + altura) * 2;
        System.out.println("el perimetro es de: " + resultado);
        
        return resultado;}
    
    public Ejercicio4Rectangulo crearOperacion(){
        System.out.println("ingrese primer numero");
        base = leer.nextInt();
        System.out.println("ingrese segundo numero");
        altura = leer.nextInt();
        return new Ejercicio4Rectangulo(altura,base);
    }
 
    public void dibujar(){
        
        for(int i = 0; i < altura; i++ ){
           for(int f = 0; f < base; f++ ){
               if (i == 0 || f == base-1 || f == 0 || i == altura-1){
                   System.out.print("* ");
               }else {
                   System.out.print("  ");
               }
                   
                   
           }
           System.out.println(" ");
        }
    }
    
}
