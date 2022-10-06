/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Carta;

/**
 *
 * @author jdeslarmes
 */
public class servicioCarta {
    
    Carta c1 = new Carta();

    
    public void mostrarCarta(Carta c1){
        
        System.out.println("El número de su carta es: "+ c1.getNumero()+" del palo: " + c1.getPalo());
    }
    
}
