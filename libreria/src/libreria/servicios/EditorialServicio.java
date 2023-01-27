/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import persistencia.AutorJpaController;
import persistencia.EditorialJpaController;

/**
 *
 * @author jdeslarmes
 */
public class EditorialServicio {
    
    Scanner leer = new Scanner(System.in);
    EditorialJpaController editorialjpa = new EditorialJpaController();
    Editorial editorial = new Editorial();

    
    public void crearEditorialDB ()throws Exception{
        
        try{
        System.out.println("Ingrese el id (como long): ");
        editorial.setId(leer.nextLong());
        System.out.println("Ingrese el nombre de editorial: ");
        editorial.setNombre(leer.next());
        System.out.println("Ingrese el alta del autor (true/false):");
        editorial.setAlta(leer.nextBoolean());

        editorialjpa.create(editorial);
        
        }catch (Exception e) {
            throw e;
        }   
        
    }
    
    
        public Editorial consultarEditorial(Long id) throws Exception{

        try{
       
        Editorial editorial = editorialjpa.findEditorial(id);
        
        return editorial;
        
        }catch (Exception e) {
            throw e;
        }   
    }    
     public Editorial mostraEditorialPorNombre(String nombre)throws Exception{
        
        try{
        
        Editorial editorial = editorialjpa.mostrarEditorialPorNombre(nombre);
        
        return editorial;
        
        }catch (Exception e) {
            throw e;
        }   
        
        
    }
    
        public boolean validarEditorialPorNombre(String nombre)throws Exception{
        
        try{
        
        boolean respuesta = editorialjpa.validarEditorialPorNombre(nombre);
        
        return respuesta;
        
        }catch (Exception e) {
            throw e;
        }   
        
        
    }
        
        public void mostrarLibroPorEditorial ()throws Exception{
        try{
            System.out.println("Ingrese el nombre de la editorial de los libros que desea ver: ");
            String nombreEditorial = leer.next();
            
           editorialjpa.mostrarLibrosPorNombreEditorial(nombreEditorial);
          

        }catch (Exception e) {
            throw e;
        }       
        } 
     
}