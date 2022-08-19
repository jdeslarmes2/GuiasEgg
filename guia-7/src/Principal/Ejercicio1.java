/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Entidades.Libro;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        Libro l1 = new Libro();
        System.out.println("Ingrese el ISBN, título, autor y páginas del libro: ");
        l1.setISBN(leer.next());
        l1.setTitulo(leer.next());
        l1.setAutor(leer.next());
        l1.setPaginas(leer.nextInt());
        System.out.println(l1);

    }
    
}
