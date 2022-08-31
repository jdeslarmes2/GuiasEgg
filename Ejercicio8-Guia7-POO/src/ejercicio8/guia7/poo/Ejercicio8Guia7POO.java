/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8.guia7.poo;

import Etiquetas.Cadena;
import Servicio.CadenaServicio;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio8Guia7POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        CadenaServicio cs = new CadenaServicio();
    
        Cadena c1 = cs.crearCadena(); 
        
        cs.mostrarVocales(c1);
        
        cs.invertirFrase(c1);
        
        cs.vecesRepetido(c1);
        
        cs.compararFrase(c1);
        
        cs.unirFrase(c1);
        
        cs.reemplazar(c1);
        
        cs.contiene(c1);
                
        
    }
  
}
