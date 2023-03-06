
package com.example.noticias.egg.servicios;

import com.example.noticias.egg.entidades.Imagen;
import com.example.noticias.egg.excepciones.MiException;
import com.example.noticias.egg.repositorios.ImagenRepositorio;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenServicio {
    
    
    @Autowired
    private ImagenRepositorio imagenRepositorio;
    
    public Imagen guardarImagen(MultipartFile archivo) throws MiException{
        
        if(archivo!= null){
            
            try {
                Imagen imagen = new Imagen();
                
                imagen.setNombre(archivo.getName());
                imagen.setMime(archivo.getContentType());
                imagen.setContenido(archivo.getBytes());
                
                imagenRepositorio.save(imagen);

                return imagen;
                
            } catch (IOException ex) {
                throw new MiException(ex.getMessage());
                
            }
        }
 
        return null;
        
    }
        public Imagen modificarImagen(MultipartFile archivo, String id) throws MiException{
        
        if(archivo!= null){
            
            try {
                Imagen imagen = new Imagen();
                
                if(id != null){
                    Optional <Imagen> respuestaImagen = imagenRepositorio.findById(id);
                      if(respuestaImagen.isPresent()){
                          imagen = respuestaImagen.get();
                      }
                  
                }
                
                imagen.setNombre(archivo.getName());
                imagen.setMime(archivo.getContentType());
                imagen.setContenido(archivo.getBytes());
                
                imagenRepositorio.save(imagen);

                return imagen;
                
            } catch (IOException ex) {
               throw new MiException("La imagen no se pudo modificar");
            }
        }
 
        return null;
        
    }
        
        
        public void eliminarImagen(MultipartFile archivo, String idImagen) throws MiException{
            
            //if(archivo!= null){
            
           //     Imagen imagen = new Imagen();
           //     if(id != null){
           //         Optional <Imagen> respuestaImagen = imagenRepositorio.findById(id);
           //         if(respuestaImagen.isPresent()){
           //             imagen = respuestaImagen.get();
           //         }
           //     }
                imagenRepositorio.deleteById(idImagen);
        //}
    }           
}
