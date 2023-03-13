
package com.example.noticias.egg.repositorios;

import com.example.noticias.egg.entidades.Noticia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepositorio extends JpaRepository <Noticia, String>{
    
    @Query("SELECT n FROM Noticia n WHERE n.titulo = :titulo")            //POR FAVOR RESPETAR LOS ESPACIOS DEL IGUAL Y DOS PUNTOS EN LA BÚSQUEDA!!!!
     public Noticia buscarPorTitulo(@Param ("titulo") String titulo); 
     
     @Query("SELECT n FROM Noticia n WHERE n.periodista.id = :id")          //idPeriodista es lo que recibo de parámetro para realizar la query y se relaciona con el @Param("idPeridista") deben ser iguales
     public List<Noticia> buscarPorId(@Param ("id") String id);            //El String idPeriodista es el atributo que recibe para la busqueda y lo vinculo el Parámetro del método con los campos de la query que corresponde por el @Param
     
     
}
