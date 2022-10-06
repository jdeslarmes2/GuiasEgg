/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class ServicioAlumno {

    Scanner leer = new Scanner(System.in);
    private List <Alumno> alumnos = new ArrayList();
    Alumno a1 = new Alumno();
    
    public Alumno crearAlumno(){
        

        ArrayList<Integer> notasAl = new ArrayList();
        System.out.println("Ingrese el nombre del alumno: ");
        String nombre = leer.next();
        System.out.println("Ingrese la primera nota del alumno: ");
        Integer n1 = leer.nextInt();
        notasAl.add(n1);
        System.out.println("Ingrese la segunda nota del alumno: ");
        Integer n2 = leer.nextInt();
        notasAl.add(n2);
        System.out.println("Ingrese la tercera nota del alumno: ");
        Integer n3 = leer.nextInt();   
        notasAl.add(n3);
        //Completo la lista de Alumnos
        Alumno a = new Alumno(nombre, notasAl);
        alumnos.add(a);
        //Devuelvo el objeto Alumno
        return a;

        
    }   
    public void agregarAlumno(){
       String respuesta = null; 
     do{
        System.out.println("¿Si quiere crear otro alumno oprima C, o si quiere salir oprima cualquier otra tecla: ");
        respuesta = leer.next();
               
                if(respuesta.equalsIgnoreCase("C")){
                crearAlumno();
                }
       }while(respuesta.equalsIgnoreCase("C"));

    }
   public void mostrarListaAlumnos(){
       
<<<<<<< HEAD
=======
       //Mostrar Lista con Interador
>>>>>>> e10837c (Primero de Guia 8 Colecciones)
       
       Iterator<Alumno> it = alumnos.iterator();
       System.out.println("Los alumnos actuales de la lista son: ");
        while(it.hasNext()){
            Alumno var = it.next();
            System.out.println(var.toString());
        }
       }
 
       public void mostrarLista2Alumnos(){
       
<<<<<<< HEAD
=======
           //Mostrar Lista con for each
>>>>>>> e10837c (Primero de Guia 8 Colecciones)
       
       System.out.println("Los alumnos actuales de la lista son: ");
           for (Alumno aux: alumnos) {
               System.out.println(aux);
           }
        }
       
<<<<<<< HEAD
=======
       public void notaFinal(){
           ArrayList <Integer> s = new ArrayList();
           int sum = 0;
           System.out.println("Ingrese el alumno que desea calcular su nota final: ");
           String alum = leer.next();
           
           for (int i = 0; i < alumnos.size(); i++) {
               
               if(alumnos.get(i).getNombre().equalsIgnoreCase(alum)){
                   s = alumnos.get(i).getNotas();
               }
           }
           //Sumatoria de las notas por alumno
           for (int i = 0; i < s.size(); i++) {
               sum = sum + s.get(i);
               
           }
           double prom = (double)sum/3;
           System.out.println("El promedio del alumno "+ alum + " es de " + prom);
       }
       
>>>>>>> e10837c (Primero de Guia 8 Colecciones)
}   
    

