
package com.example.noticias.egg.controladores;

import com.example.noticias.egg.entidades.Noticia;
import com.example.noticias.egg.entidades.Usuario;
import com.example.noticias.egg.servicios.NoticiaServicio;
import com.example.noticias.egg.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/imagen")
public class ImagenControlador {
    
    @Autowired
    private NoticiaServicio noticiaServicio; 
    
    @Autowired
    private UsuarioServicio usuarioServicio; 
    
    
    
    
    @GetMapping("/imgNoticia/{id}")
    
    public ResponseEntity<byte[]> imagenNoticia(@PathVariable String id){
    
    Noticia noticia = noticiaServicio.getOne(id);
    
    byte[] imagen = noticia.getImagen().getContenido();
    
    HttpHeaders header = new HttpHeaders();
    
    header.setContentType(MediaType.IMAGE_JPEG);
    
    return new ResponseEntity<>(imagen, header, HttpStatus.OK);
    
    
    
}
    @GetMapping("/perfil/{id}")
    public ResponseEntity<byte[]> imagenUsuario(@PathVariable String id){
    
    Usuario usuario = usuarioServicio.getOne(id);
    
    byte[] imagen = usuario.getImagen().getContenido();
    
    HttpHeaders header = new HttpHeaders();
    
    header.setContentType(MediaType.IMAGE_JPEG);
    
    return new ResponseEntity<>(imagen, header, HttpStatus.OK);    
    }
}
