/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo3;
import java.util.Scanner;
/**
 *
 * @author skais
 */
public class Ejercicio2Operacion {
    Scanner leer = new Scanner(System.in);
    private int num1;
    private int num2;

    public Ejercicio2Operacion(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Ejercicio2Operacion() {
        
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public Ejercicio2Operacion crearOperacion(){
        System.out.println("ingrese primer numero");
        num1 = leer.nextInt();
        System.out.println("ingrese segundo numero");
        num2 = leer.nextInt();
        return new Ejercicio2Operacion(num1,num2);
    }
    public int sumar(){
    int resultado = num1 + num2;
    System.out.println("el resultado de la operacion es: " + resultado);
    return resultado;}
    
    public int restar(){
    int resultado = num1 - num2;
    System.out.println("el resultado de la operacion es: " + resultado);
    
    return resultado;}
    
    public int multiplicar(){
    int resultado = num1 * num2;
    System.out.println("el resultado de la operacion es: " + resultado);
    return resultado;}
    
    public float Dividir(){
        while(num1 == 0 || num2 == 0){
            if(num1 == 0 || num2 == 0){
            System.out.println("che, no seas pelotudo, redefini los valores...");
            crearOperacion();
            }
        }
        
        float resultado = num1 / num2;
        System.out.println("el resultado de la operacion es: " + resultado);
    return (float) resultado;}
}
