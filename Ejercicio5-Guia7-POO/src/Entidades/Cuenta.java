/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author jdeslarmes
 */
public class Cuenta {
    
    private int numeroCuenta;
    private int dni;
    private Double saldoActual;
    private Double interes;

   //Constructor por defecto

    public Cuenta() {
    }
    
    //Cosntructor por parámatros

    public Cuenta(int numeroCuenta, int dni, Double interes) {
        this.numeroCuenta = numeroCuenta;
        this.dni = dni;
        this.interes = interes;
    }


    
    //getter & setter

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }


    
}

