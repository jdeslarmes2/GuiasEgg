/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author LMACHADO
 */
public class Alumno {
    private String nombreCompleto;
    private int dni;
    private int votosRecibidos;

    public Alumno() {
    }

    public Alumno(String nombreCompleto, int dni, int votosRecibidos) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.votosRecibidos = votosRecibidos;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getVotosRecibidos() {
        return votosRecibidos;
    }

    public void setVotosRecibidos(int votosRecibidos) {
        this.votosRecibidos = votosRecibidos;
    }

    @Override
    public String toString() {
        return "Alumno: " + "\n - Nombre Completo: " + nombreCompleto + "\n - DNI: " + dni + "\n - Votos Recibidos: " + votosRecibidos;
    }

    
}
