/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Ahorcado;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class AhorcadoServicio {
    
    Scanner leer = new Scanner(System.in);
    
    Ahorcado a1 = new Ahorcado();
    
    public void crearJuego(){
        
        System.out.println("Ingrese la palabra a adivinar: ");
        String palabra = leer.next();
        int longitud = palabra.length();
        //String [] vector = new String[longitud];
        //a1.setPalabra(new String[longitud]);
        //a1.getPalabra().toString();
        System.out.println("Ingrese la cantidad máxima de jugadas: ");
        a1.setCantidadJugadasMax(leer.nextInt());
        System.out.println("La cantidad de caracteres de la palabra es: "+ longitud);
        
        String [] vector = new String[longitud];

        int i;
        for (i=0; i<longitud; i++){
           vector [i] = palabra.substring(i, i+1);
        }
        
        //Le doy valor al atributo de vector palabra
        a1.setPalabra(vector);
        
         // Le doy valor 0 al atributo cantidad de letras encontradas
        a1.setCantidadLetras(0);
        
        a1.setOportunidades(a1.getCantidadJugadasMax());

        //Verifico si completo el vector palabra (no funciona con toString)
        // a1.getPalabra().toString(); 
        for (i=0; i<longitud; i++){
            System.out.print("[" + vector [i] + "]");
        }
        System.out.println("");
    }
   
    public void longitud(){
        
        System.out.println("Longitud de la palabra: "+ a1.getPalabra().length);
        
    }
    
    public void buscarLetra(String letra){
        
        int i;
        int encontrada=0;
        String [] vector = a1.getPalabra();
        
        for (i=0; i<a1.getPalabra().length; i++){
        
            if (vector [i].equals(letra)){
                encontrada++;
            }
        }
        if (encontrada !=0){
            System.out.println("La letra pertenece a la palabra");    
        } else {
            System.out.println("La letra no pertence a la palabra");
        }

    }
    
    public boolean encontradas(String letra){
        
        int i;
        boolean encuentra = false;
        int cantEncontrada=0;
        String [] vector = a1.getPalabra();
        
        for (i=0; i<a1.getPalabra().length; i++){
        
            if (vector [i].equals(letra)){
                cantEncontrada++;
                
            }
        }
        a1.setCantidadLetras(a1.getCantidadLetras()+cantEncontrada);

        int restantes =  a1.getPalabra().length - a1.getCantidadLetras();
        
        if (cantEncontrada !=0){
            System.out.println("Número de letras (encontradas, faltantes): ("+ a1.getCantidadLetras()+","+restantes+")"); 
            return encuentra = true;
            
        } else {
            System.out.println("Número de letras (encontradas, faltantes): ("+ a1.getCantidadLetras()+","+restantes+")"); 
            return encuentra = false;
        }

    }
    
    public void intentos(Boolean prueba){
        
       // boolean solucion = encontradas(letra);

//        if(a1.getOportunidades()!=0){
              if( prueba == false){
                  a1.setOportunidades(a1.getOportunidades()-1);
              }
              System.out.println("Número de oportunidades restantes: "+ a1.getOportunidades());
 //       } else {
 //           System.out.println("Lo sentimos, no hay más oportunidades");
 //       }
    
    }
            
     
    public void juego(){
        
      int i;
      for (i=0; i<a1.getCantidadJugadasMax();i++){
        
        if (a1.getCantidadLetras()==a1.getPalabra().length){
            System.out.println("En hora buena, a encontrado la palabra");  
            break;
        }
              if(a1.getCantidadLetras()<a1.getPalabra().length && a1.getOportunidades()!=0){
               System.out.println("Ingrese una letra:");
               String letra = leer.next();
               longitud();
               buscarLetra(letra);
               boolean prueba = encontradas(letra);
               intentos(prueba);
              } 

         if (a1.getOportunidades()== 0){
             System.out.println("Lo sentimos, no hay más oportunidades");
             break;
         } 
      }

    }
}
