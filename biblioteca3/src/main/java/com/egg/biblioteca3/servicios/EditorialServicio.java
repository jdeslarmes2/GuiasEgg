
package com.egg.biblioteca3.servicios;

import com.egg.biblioteca3.entidades.Autor;
import com.egg.biblioteca3.entidades.Editorial;
import com.egg.biblioteca3.entidades.repositorios.EditorialRepositorio;
import com.egg.biblioteca3.excepciones.MiException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EditorialServicio {
    
    @Autowired
    EditorialRepositorio editorialRepositorio;
    
    @Transactional
    public void crearEditorial(String nombre) throws MiException{
        
        validar(nombre);
        
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        
        editorialRepositorio.save(editorial);
        
    }
    
          public List<Editorial> listarEditoriales(){
        
        List <Editorial> editoriales = new ArrayList();
        
        editoriales = editorialRepositorio.findAll();  //Relleno la lista con todos los que encuentra
        
        return editoriales;
    }
          
          public void modificarEditorial (String id, String nombre) throws MiException{     //El id de entrada lo necesito para buscar la Editorial
              
              validar(nombre);
              
              Optional<Editorial> respuesta = editorialRepositorio.findById(id); //Busco EDitorial con id dentro de mi base de datos
             
              
              if(respuesta.isPresent()){
              
                  Editorial editorial = respuesta.get(); //Tomo el objeto editorial si encuenta uno en mi base de datos con ese id. 
                  
                  editorial.setNombre(nombre); //Modifico el nombre nuevo de la editorial.
                  
                  editorialRepositorio.save(editorial);  //Peristo en mi base de datos el objeto con el nombre modificado con el método de l repositorio que viene con el JPA 
              }
              
          }
          
           private void validar(String nombre) throws MiException {
           if(nombre.isEmpty() || nombre == null){
           throw new MiException("El nombre de la editorial no puede ser nulo o vacio");
       }
       }        
        
}
