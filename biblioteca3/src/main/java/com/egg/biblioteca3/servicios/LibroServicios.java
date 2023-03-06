
package com.egg.biblioteca3.servicios;

import com.egg.biblioteca3.entidades.Autor;
import com.egg.biblioteca3.entidades.Editorial;
import com.egg.biblioteca3.entidades.Libro;
import com.egg.biblioteca3.entidades.repositorios.AutorRepositorio;
import com.egg.biblioteca3.entidades.repositorios.EditorialRepositorio;
import com.egg.biblioteca3.entidades.repositorios.LibroRepositorio;
import com.egg.biblioteca3.excepciones.MiException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicios {
    
    @Autowired  //Indicar que esta variable va a ser inicializada por el servidor de aplicaciones (inyeccion de dependencias)
    private LibroRepositorio libroRepositorio;
    
    @Autowired 
    private AutorRepositorio autorRepositorio;
    
    @Autowired 
    private EditorialRepositorio editorialRepositorio;
    
    //Con @Transacción si el método se usa sin una excepcion se realiza un commit a la base de datos, pero si lanza una exepcion y no es atrapada se vuelve atras con la TRANSACCION, osea un rollback, y no se aplica nada en la base de datos. OSEA TODOS LOS METODOS QUE GENERAN CAMBIOS DEBEN SER TRANSACCIONALES
    //ESTE METODO HACE UNA PERSISTENCIA ENTONCES MODIFICA LA BASE DE DATOS
    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException{
        

        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
      
        
        Autor autor =autorRepositorio.findById(idAutor).get();
        Editorial editorial = editorialRepositorio.findById(idEditorial).get();
        Libro libro = new Libro();
        

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());
        
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        
        //Llamo a los repo que extiende de JPArepository una vez instanciada el libro repositorio, en este caso guarda o persiste en base de datos.
        libroRepositorio.save(libro);
        
        
        //NOTA: CON EL CLEAN AND BUILT DESCARGA LAS DEPENDECIAS NUEVAMENTE
        
    }
    
    public List<Libro> listarLibros(){
        
        List <Libro> libros = new ArrayList();
        
        libros = libroRepositorio.findAll();  //Relleno la lista con todos los que encuentra
        
        return libros;
    }
    
   // -----------------METODO MODIFICAR-----------------------------
    
    public void modificarLibro(Long isbn, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiException{
        
        
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        
        //La calse Optional es para cuando el id que nos da el usuario vine con un formato diferentre al que debía venir.
        // No podemos usar como veniamos haciendoi: Libro libro = libroRepositorio.findById(isbn).get()
        //Objeto contenedor que puede o no ser nulo, si el valor esta presente devuelve verdadero y puede retornar el valor con el get
        
        Optional<Libro> respuesta = libroRepositorio.findById(isbn);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idAutor);
        
        Autor autor = new Autor();
        Editorial editorial = new Editorial();
        
        if(respuestaAutor.isPresent()){
            
            autor = respuestaAutor.get();
 
        }
        
        if(respuestaEditorial.isPresent()){
            
            editorial = respuestaEditorial.get();
            
        }
        if(respuesta.isPresent()){
            
            Libro libro = respuesta.get();
            
            libro.setTitulo(titulo);  //Seteo atributo
            
            libro.setAutor(autor);
            
            libro.setEditorial(editorial);
            
            libro.setEjemplares(ejemplares);
            
            libroRepositorio.save(libro);
        }
        
    }
    
    private void validar(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException{
        
        //Validación de dato ej. si es nulo para que lance la excepción
        
        if(isbn == null){
            throw new MiException("El isbn no puede ser nulo");
        }
        if(titulo.isEmpty() || titulo == null){
            throw new MiException("El titulo no pude ser nulo o esta vacío");  //Como estas validaciones con excepciones están antes del código que persiste en la base de datos, si surge no se guarda en la DB.
        }
        if(ejemplares  == null){
            throw new MiException("Lo ejemplares no pueden ser nulos");
        }
        if(idAutor.isEmpty() || idAutor == null){
            throw new MiException("El id del autor no pude ser nulo o esta vacío");  //Como estas validaciones con excepciones están antes del código que persiste en la base de datos, si surge no se guarda en la DB.
        }
          if(idEditorial.isEmpty() || idEditorial == null){
            throw new MiException("El id del la editorial no pude ser nulo o esta vacío");  //Como estas validaciones con excepciones están antes del código que persiste en la base de datos, si surge no se guarda en la DB.
        }
        
        
        
    }
}
