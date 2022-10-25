/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.HashSet;

/**
 *
 * @author LMACHADO
 */
public class Voto {
    private Alumno votante;
    private HashSet <Alumno> votados;

    public Voto() {
    }

    public Voto(Alumno votante, HashSet<Alumno> votados) {
        this.votante = votante;
        this.votados = votados;
    }

    public Alumno getVotante() {
        return votante;
    }

    public void setVotante(Alumno votante) {
        this.votante = votante;
    }

    public HashSet<Alumno> getVotados() {
        return votados;
    }

    public void setVotados(HashSet<Alumno> votados) {
        this.votados = votados;
    }

    @Override
    public String toString() {
        return "Voto" + "\n- Votante: " + votante + "\n- Votados=" + votados;
    }
    
    
}
