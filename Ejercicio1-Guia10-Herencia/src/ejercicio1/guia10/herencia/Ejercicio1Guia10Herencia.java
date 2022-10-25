/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.guia10.herencia;

import entidades.Animal;
import entidades.Gato;
import entidades.Perro;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio1Guia10Herencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Animal perro1 = new Perro("Dalmo", "Carne", "10", "Dalmata");
        perro1.Alimentarse(perro1);
        Animal perro2 = new Perro("Teddy", "Croquetas", "10", "Chiguagua");
        perro1.Alimentarse(perro2);
        Animal gato1 = new Gato("Pelusa", "Galletas", "10", "Silvestre");
        gato1.Alimentarse(gato1);
        
        
    }
    
}
