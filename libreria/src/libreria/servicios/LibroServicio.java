/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;
import javax.persistence.NoResultException;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import persistencia.LibroJpaController;

/**
 *
 * @author jdeslarmes
 */
public class LibroServicio {
    Scanner leer = new Scanner(System.in);
    LibroJpaController librojpa = new LibroJpaController();
    Libro libro = new Libro();
    AutorServicio as = new AutorServicio();
    EditorialServicio es = new EditorialServicio();
    
    public Libro crearLibro()throws Exception{{
        
        try {
        System.out.println("Ingrese ISBN: ");
        libro.setIsbn(leer.nextLong());
        leer.nextLine();
        System.out.println("Ingrese nombre de libro: ");
        libro.setTitulo(leer.nextLine());
        
        System.out.println("Ingrese año de libro: ");
        libro.setAnio(leer.nextInt());
        System.out.println("Ingrese ejemplares: ");
        libro.setEjemplares(leer.nextInt());
        System.out.println("Ingerese ejemplares prestados: ");
        libro.setEjemplaresPrestados(leer.nextInt());
        System.out.println("Ingrese ejemplares restantes: ");
        libro.setEjemplaresRestantes(leer.nextInt());
        System.out.println("Ingrese alta (true/false): ");
        libro.setAlta(leer.nextBoolean());
        leer.nextLine();
        System.out.println("Ingrese el nombre del autor:");
        String nombreAutor = leer.nextLine();
        if (as.validarAutorPorNombre(nombreAutor) == true){
            libro.setAutor(as.mostraAutorPorNombre(nombreAutor));
        }else {
            System.out.println("Debe crear nuevo autor");
            as.crearAutorDB();
            libro.setAutor(as.mostraAutorPorNombre(nombreAutor));
        }
        System.out.println("Ingrese el nombre de editorial:");
        String nombreEditorial = leer.nextLine();
        if (es.validarEditorialPorNombre(nombreEditorial) == true){
            libro.setEditorial(es.mostraEditorialPorNombre(nombreEditorial));
        }else {
            System.out.println("Debe crear nueva editorial");
            es.crearEditorialDB();
            libro.setEditorial(es.mostraEditorialPorNombre(nombreEditorial));
        }
        
        return libro;
        
        }catch (Exception e) {
            throw e;
        }   
        
        //Prueba de creación
        //Libro libro = new Libro(3455L,"El Principito",2022, 54, 34, 20, true, null, null);
        //return libro;
     }
    }
    // 7)Creación de Libro 
    
    public void crearlibroDB(Libro l) throws Exception{
        try{
            // Libro l = crearLibro(); Prueba de 
            
            librojpa.create(l);
        }catch (Exception e) {
            throw e;
        }
    }
    
    // 7) Modificar libro
    
        public void modificarlibroDB(Libro l) throws Exception{
        try{
            librojpa.edit(l);
          
        }catch (Exception e) {
            throw e;
        }
    }
        // 7) Consultar libro, devuelve libro por ID
    
        public Libro consultarlibroDB(long id) throws Exception{
        try{
            return librojpa.findLibro(id);
          
        }catch (Exception e) {
            throw e;
        }
     }
     
         // 7) Eliminar libro, elimina libro por ID
    
        public void eliminarlibroDB(long id) throws Exception{
        try{
            librojpa.destroy(id);
            System.out.println("El libro con id" + id + " se ha borrado");
          
        }catch (Exception e) {
            throw e;
        }
     }
        
        public void mostrarLibroNombre (){
        try{
            System.out.println("Ingrese el nombre del libro que desea mostrar: ");
            String nombre = leer.next();
            
           Libro libroSeleccionado = librojpa.mostrarLibroPorNombre(nombre);
          
            System.out.println(libroSeleccionado.toString());
        }catch (Exception e) {
            throw e;
        }
        }
        
        public void mostrarLibrosEjemplares (){
        try{
            System.out.println("Ingrese el numero de ejemplares de los libros: ");
            int ejemplares = leer.nextInt();
            
            librojpa.mostrarLibrosPorCantidadEjemplares(ejemplares);

        }catch (Exception e) {
            throw e;
        }
        }
        
        public void editarParametroLibro(){
        try{
            System.out.println("Ingrese el isbn del libro a modificar: ");
            int isbn= leer.nextInt();
            
            librojpa.editarParametroLibro(isbn);
            
         }catch(NoResultException e) {                                           // Excepción por si no encuentar nombre
             System.out.println("No se encontró el isbn del libro indicado");   
         }
            
        }
        
        public void eliminarLibroNombre(){
        try{
            System.out.println("Ingrese el nombre del libro a borrar: ");
            String nombreLibro= leer.next();
            
            librojpa.eliminarLibroPotNombre(nombreLibro);
            
         }catch(NoResultException e) {                                           // Excepción por si no encuentar nombre
             System.out.println("No se encontró el isbn del libro indicado");   
         }
            
        }
         public void mostrarLibroPorAutor (){
        try{
            System.out.println("Ingrese el nombre del autor de los libros que desea ver: ");
            String nombreAutor = leer.next();
            
           librojpa.mostrarLibrosPorAutor(nombreAutor);
          

        }catch (Exception e) {
            throw e;
        }       
        }      
              
        
        
}
        
     

        
        
        
        
        
        

