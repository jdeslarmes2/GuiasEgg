
package com.egg.biblioteca3.entidades.repositorios;

import com.egg.biblioteca3.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository <Autor, String> {
    
    
}
