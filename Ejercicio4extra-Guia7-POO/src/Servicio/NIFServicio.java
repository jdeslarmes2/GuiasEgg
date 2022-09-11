/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidades.NIF;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class NIFServicio {
    

    Scanner leer = new Scanner(System.in);
    
    NIF n1 = new NIF();

    
    public NIF crearNIF(){
        
        //Otra forma de guardar los argumentos, por parámetro,
       // System.out.println("Ingrese el número de DNI a crear el NIF, sin puntos: ");
       // n1.setNumeroDNI(leer.nextInt());
       // String [] vector = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
       // n1.setLetra(vector[(int)(n1.getNumeroDNI()% 23)]);
        
        //Forma de guardar los argumentos por objeto nuevo NIF
        System.out.println("Ingrese el número de DNI a crear el NIF, sin puntos: ");
        int numeroDNI1 = leer.nextInt();
        String [] vector = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        String letra1 = vector[(int)(numeroDNI1 % 23)];
       
       
        
        return new NIF (numeroDNI1, letra1);
    }
    
    
    
    public void mostrarNIF(NIF nif){
        
        System.out.println("El número de NIF es: "+nif.getNumeroDNI()+"-"+nif.getLetra());  
 
        
    }
    
}
