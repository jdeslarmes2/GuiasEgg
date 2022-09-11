/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4extra.guia7.poo;

import Entidades.NIF;
import Servicio.NIFServicio;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio4extraGuia7POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        NIFServicio ns = new NIFServicio();
        
        NIF nf = ns.crearNIF();
        
        ns.mostrarNIF(nf);
   
        
    }
    
}
