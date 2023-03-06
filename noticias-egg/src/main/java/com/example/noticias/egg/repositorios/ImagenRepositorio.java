
package com.example.noticias.egg.repositorios;

import com.example.noticias.egg.entidades.Imagen;
import com.example.noticias.egg.entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    
    
@Repository
public interface ImagenRepositorio extends JpaRepository <Imagen, String>{
    
    
}
