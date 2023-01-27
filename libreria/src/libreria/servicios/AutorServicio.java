/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Autor;
import persistencia.AutorJpaController;

/**
 *
 * @author jdeslarmes
 */
public class AutorServicio {
    
    Scanner leer = new Scanner(System.in);
    AutorJpaController autorjpa = new AutorJpaController();
    Autor autor = new Autor();
    
    public void crearAutorDB ()throws Exception{
        
        try{
        System.out.println("Ingrese el id: ");
        autor.setId(leer.nextInt());
        System.out.println("Ingrese el nombre del autor: ");
        autor.setNombre(leer.next());
        System.out.println("Ingrese el alta del autor (true/false):");
        autor.setAlta(leer.nextBoolean());

        autorjpa.create(autor);
        
        }catch (Exception e) {
            throw e;
        }   
    }
    public Autor consultarAutor(int id) throws Exception{

        try{
       
        Autor autor = autorjpa.findAutor(id);
        
        return autor;
        
        }catch (Exception e) {
            throw e;
        }   
    }    
     public Autor mostraAutorPorNombre(String nombre)throws Exception{
        
        try{
        
        Autor autor = autorjpa.mostrarAutorPorNombre(nombre);
        
        return autor;
        
        }catch (Exception e) {
            throw e;
        }   
        
        
    }
    
        public boolean validarAutorPorNombre(String nombre)throws Exception{
        
        try{
        
        boolean respuesta = autorjpa.validarAutorPorNombre(nombre);
        
        return respuesta;
        
        }catch (Exception e) {
            throw e;
        }   
        
        
    }
     
     
     
     
}
