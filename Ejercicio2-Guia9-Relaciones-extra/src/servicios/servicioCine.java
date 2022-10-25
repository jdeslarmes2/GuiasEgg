/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Cine;
import entidades.Espectador;
import entidades.Pelicula;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author jdeslarmes
 */
public class servicioCine {
    
    Scanner leer = new Scanner(System.in);
    
    Cine c1 = new Cine();
    Pelicula p1 = new Pelicula();
    servicioPelicula sp = new servicioPelicula();
    servicioEspectador se = new servicioEspectador(); 
    
    ArrayList<Espectador> Espectadores = new ArrayList();
    
    
    TreeMap <String, Espectador> sala = new TreeMap();  
     
    public static int generarNumeroAleatorio (int minimo, int maximo) {
    int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
    return num;
    
    }
    public void crearCine(Pelicula p1){
        
        String [][] sala = new String [8][6];
        c1.setSala(sala);
        System.out.println("Ingrese el precio de la sala para ver la película: ");
        c1.setPrecio(leer.nextDouble());
        // Traigo la película al nuevo objeto p1
        c1.setPelicula(p1);
    }
    
    
    public void completarSala(){
    
        Espectadores = se.crearListaPosiblesEspectadores();
        
    int contador = 0;
    
    //Creo la sala con sus asientos en el mapa y sin completar los espectadores
        String[] letraAsiento = {"A","B","C","D","E","F"};
        for (int i = 0; i < Espectadores.size(); i++) {
            for (int j = 0; j < 8; j++) {
            contador++;
            sala.put(contador+letraAsiento[0], new Espectador(Espectadores.get(i)));
            sala.put(contador+letraAsiento[1], null);
            sala.put(contador+letraAsiento[2], null);
            sala.put(contador+letraAsiento[3], null);
            sala.put(contador+letraAsiento[4], null);
            sala.put(contador+letraAsiento[5], null); 
        }
          
        
        System.out.println(letraAsiento[generarNumeroAleatorio (1,6)]);
             
        for (int i = 0; i < Espectadores.size(); i++) {
            contador ++;
            Espectador e = Espectadores.get(i);
             sala.put(contador+"A", new Espectador(e));
            
            
        }
        
        
        //Muestro la sala
        for (Map.Entry<String, Espectador> aux : sala.entrySet()) {
            String key = aux.getKey();
            Espectador value = aux.getValue();
            
            System.out.println("Asiento: "+ key+ " Espectador: "+value);
        }
        
    
    
    
    }
     public void mostrarSala(Espectador e1){
        
//        int contador=0; 
//         
//        for (int i = 0; i < 8; i++) {
//            for (int j=0; j < 6; j++) {
//                
//                    if(sala[i][j] != null){
//                        System.out.println("Su lugar esta completo, buscaremos otro lugar");
//                        do{
//                          contador++;   
//                          if (i<8 && j<6 && sala[i+contador][j+contador] == null){
//                             sala[i+contador][j+contador]= "X"; 
//                          } else {
//                          System.out.println("El nuevo asiento seleccionado también esta completo, buscaremos otro lugar"); 
//                          }  
//                        } while(sala[i+contador][j+contador] != null);
//                    } else {
//                    sala[i][j]= "X";     
//                    }
//                }
//        
//    }
//    
    
    
  }
}