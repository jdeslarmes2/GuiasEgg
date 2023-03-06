
package com.example.noticias.egg.repositorios;

import com.example.noticias.egg.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepositorio extends JpaRepository <Administrador, String> {
    
}
