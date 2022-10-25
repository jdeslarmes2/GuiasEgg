/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author jdeslarmes
 */
public class Voto {
    
    
    private Alumno alumnoVotante;
    private HashSet <Alumno> votados;

    public Voto() {
    }

    public Voto(Alumno alumnoVotante, HashSet<Alumno> votados) {
        this.alumnoVotante = alumnoVotante;
        this.votados = votados;
    }

    public Alumno getAlumnoVotante() {
        return alumnoVotante;
    }

    public void setAlumnoVotante(Alumno alumnoVotante) {
        this.alumnoVotante = alumnoVotante;
    }

    public HashSet<Alumno> getVotados() {
        return votados;
    }

    public void setVotados(HashSet<Alumno> votados) {
        this.votados = votados;
    }

    @Override
    public String toString() {
        return "Voto{" + "alumnoVotante=" + alumnoVotante + ", votados=" + votados + '}';
    }
    
}