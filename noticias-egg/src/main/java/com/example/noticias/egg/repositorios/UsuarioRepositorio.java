
package com.example.noticias.egg.repositorios;

import com.example.noticias.egg.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, String>{
    
    
    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario")
    public Usuario buscarPorNombre(@Param("nombreUsuario")String nombreUsuario);
    
}
