
package com.example.noticias.egg.repositorios;

import com.example.noticias.egg.entidades.Periodista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodistaRepositorio extends JpaRepository <Periodista, String>{
    
}
