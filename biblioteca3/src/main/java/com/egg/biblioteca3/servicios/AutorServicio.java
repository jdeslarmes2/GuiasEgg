/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca3.servicios;

import com.egg.biblioteca3.entidades.Autor;
import com.egg.biblioteca3.entidades.Libro;
import com.egg.biblioteca3.entidades.repositorios.AutorRepositorio;
import com.egg.biblioteca3.excepciones.MiException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutorServicio {
    
    @Autowired
    AutorRepositorio autorRepositorio;
    @Transactional
    public void crearAutor(String nombre) throws MiException{
        
        validar(nombre);
        
        Autor autor = new Autor();
        
        autor.setNombre(nombre);
        
        autorRepositorio.save(autor);
    }
    
        public List<Autor> listarAutores(){
        
        List <Autor> autores = new ArrayList();
        
        autores = autorRepositorio.findAll();  //Relleno la lista con todos los que encuentra
        
        return autores;
       }
        public void modificarAutor(String nombre, String id)throws MiException{
            
            validar(nombre);
            
            Optional<Autor> respuesta = autorRepositorio.findById(id);
            
            if (respuesta.isPresent()){
                Autor autor = respuesta.get();
                
                autor.setNombre(nombre);
                
                autorRepositorio.save(autor);
                
        }
    }
       public Autor getOne(String id) {                    //este método nos retorna el autor que tienen ese id
           return autorRepositorio.getOne(id);
       }
        

        
        
       private void validar(String nombre) throws MiException {
           if(nombre.isEmpty() || nombre == null){
           throw new MiException("El nombre del autor no puede ser nulo o vacio");
       }
       }        
        
        
}
