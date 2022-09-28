/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import utilidades.Comparadores;

/**
 *
 * @author jdeslarmes
 */
public class serviciopelicula {
   
Scanner leer = new Scanner(System.in);

pelicula p = new pelicula();

private List <pelicula> peliculas = new ArrayList();

  public pelicula cargarPelicula(){
    
    System.out.println("Ingrese el título de la película: ");
    p.setTitulo(leer.next()); 
    System.out.println("Ingrese la duracion en horas de la pelicula: ");
    p.setDuracion(leer.nextDouble());
    System.out.println("Ingrese el director de la pelicula: ");
    p.setDirector(leer.next());
    
    pelicula p1 = new pelicula (p.getTitulo(), p.getDirector(),  p.getDuracion()); 
    peliculas.add(p1);
    
    return p1;
    
  }

  public void agregarPelicula(){
      
      String respuesta = null; 
      do{
          System.out.println("Desea agrear una pelicula? tipear (S) si desea, (N) si no desea: ");
          respuesta = leer.next();
          if (respuesta.equalsIgnoreCase("S")){
              cargarPelicula();
          }if (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")){
              System.out.println("Su respuesta es incorrecta");
          }  
      } while (respuesta.equalsIgnoreCase("S")); 
  }
  
  public void mostrarPelicula(){
      
      System.out.println("-----------El listado de peliculas acutal es: -----------------------");
      System.out.println("");
      for (pelicula aux : peliculas) {
          System.out.println(aux);
      }
      System.out.println("");
  }
  public void mostrarMayor1(){
      
      System.out.println("------------El listado de peliculas mayores a 1 hora es: ------------------");
      System.out.println("");
      for (int i = 0; i < peliculas.size(); i++) {
          if (peliculas.get(i).getDuracion() > 1){
              pelicula p = peliculas.get(i);
              System.out.println(p);
          } 
      }
      System.out.println("");
  }
  
  public void mostrarMayorMenor(){
      
      Collections.sort(peliculas, Comparadores.ordenarMayorMenor);
      System.out.println("---------------El listado de peliculas ordenadas de mayor a menor duración es: --------------------");
      System.out.println("");
      for (pelicula pelicula1 : peliculas) {
          System.out.println(pelicula1);
      }
      System.out.println("");
  } 
  public void mostrarMenorMayor(){
      
      Collections.sort(peliculas, Comparadores.ordenarMenorMayor);
      System.out.println("---------------El listado de peliculas ordenadas de menor a mayor duración es: --------------------");
      System.out.println("");
      for (pelicula pelicula1 : peliculas) {
          System.out.println(pelicula1);
      }
      System.out.println("");
  } 
    public void mostrarPorTitulo(){
      
      Collections.sort(peliculas, Comparadores.ordenarTitulo);
      System.out.println("---------------El listado de peliculas ordenadas alfanumericamente por título es: --------------------");
      System.out.println("");
      for (pelicula pelicula1 : peliculas) {
          System.out.println(pelicula1);
      }
      System.out.println("");
  }
     public void mostrarPorDirector(){
      
      Collections.sort(peliculas, Comparadores.ordenarDirector);
      System.out.println("---------------El listado de peliculas ordenadas alfanumericamente por director es: --------------------");
      System.out.println("");
      for (pelicula pelicula1 : peliculas) {
          System.out.println(pelicula1);
      }
      System.out.println("");
  } 
  
  
  
  
  
}