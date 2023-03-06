
package com.egg.biblioteca3.entidades.repositorios;

import com.egg.biblioteca3.entidades.Autor;
import com.egg.biblioteca3.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    
    //Busqueda de libros con titulo como input
    @Query("SELECT l FROM Libro l WHERE l.titulo =: titulo")
     public Libro buscarPorTitulo(@Param ("titulo") String titulo);   //Con @Param decimos que el parámetro titulo hace referencia al atributo de la tabla representado como titulo de la busqueda del query (primera palabra titulo luego de l.). El atributo como input de titulo esta representado en l query luego de los :)
          
     //Busqueda de librois de un autor como input
     @Query("SELECT l FROM Libro l WHERE l.autor.nombre =: nombre")
     public List<Libro> buscarPorAutor(@Param ("nombre") String nombre);
     
     }