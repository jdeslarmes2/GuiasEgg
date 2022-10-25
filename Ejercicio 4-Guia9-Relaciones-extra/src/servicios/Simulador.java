/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Alumno;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import numeraciones.Apellidos;
import numeraciones.Nombres;

/**
 *
 * @author jdeslarmes
 */
public class Simulador {
    
    

    
    ArrayList<String> nombres = new ArrayList(Arrays.asList(Nombres.values()));
    ArrayList<String> apellidos = new ArrayList(Arrays.asList(Apellidos.values()));
    ArrayList <Alumno> alumnos = new ArrayList();

 public ArrayList crearListaAlumnos(){
     
  
      Collections.shuffle(nombres);
      Collections.shuffle(apellidos);
      
    //Hago un set de los arrays mezclados de nombres y apellidos y agrego al numero de dni con un random entre valores minimos y máximos
     
     for (int i = 0; i < 10; i++) {
         alumnos.add(new Alumno ((nombres.get(i).toString()+" "+apellidos.get(i).toString()),(int) (Math.random()* (40000000-30000000)+30000000), 0));
         // uso de random con max y min
         //Math.random() * (max - min) + min)
     }
     for (Alumno aux : alumnos) {
         System.out.println(aux);
     }
     
     return alumnos;
  
 }     
  public void votacion(){
 
      
      for (int i = 0; i < 10; i++) {
         
        int posicionAVotar = (int) (Math.random() * 9);
        int [] votos = {10,10,10}; // El valor inicial debe ser fuera de las posiciones de la tabla del 0 al 9
          
          for (int j = 0; j < 3; j++) {
              
          //Siempre que la posicionAVotar no sea la del mismo que va a votar o alguna de los ya votados por el mismo votante se puede hacer el set de los votos, caso contrario se vuelve a correr el random de la posición
             
             while(posicionAVotar == i || posicionAVotar == votos[0] || posicionAVotar == votos[1] || posicionAVotar == votos[2]){
                  posicionAVotar = (int) (Math.random() * 9);
             }
             alumnos.get(posicionAVotar).setVotos(alumnos.get(posicionAVotar).getVotos()+1);
             votos[j]=posicionAVotar;
        }
        
      }
     
     
  }
    
     
     
     
 }
 
 
 
 


