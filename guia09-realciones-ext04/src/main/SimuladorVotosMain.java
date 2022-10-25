/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import servicio.Simulador;

/**
 *
 * @author LMACHADO
 */
public class SimuladorVotosMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Simulador sim = new Simulador ();
        
        sim.crearAlumno();
        sim.votacion();
        
    }
    
}
