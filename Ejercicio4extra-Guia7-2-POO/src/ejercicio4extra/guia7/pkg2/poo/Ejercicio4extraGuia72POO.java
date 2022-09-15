/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4extra.guia7.pkg2.poo;

import Entidades.Fecha;
import Servicio.FechaServicio;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio4extraGuia72POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
     
      FechaServicio fs = new FechaServicio();
      
      Fecha f1 = fs.crearFecha();
      fs.verificarAno(f1);
      fs.verificarDias(f1);
      fs.mostrarDiaAnterior(f1);
      fs.mostrarDiaPosterior(f1);
      fs.verificarBisiesto(f1);
      
        
        
        
    }
    
}
