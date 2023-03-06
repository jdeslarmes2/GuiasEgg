
package com.example.noticias.egg.servicios;

import com.example.noticias.egg.entidades.Imagen;
import com.example.noticias.egg.entidades.Noticia;
import com.example.noticias.egg.entidades.Periodista;
import com.example.noticias.egg.excepciones.MiException;
import com.example.noticias.egg.repositorios.ImagenRepositorio;
import com.example.noticias.egg.repositorios.NoticiaRepositorio;
import com.example.noticias.egg.repositorios.PeriodistaRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Scanner;

@Service
public class NoticiaServicio {
    @Autowired 
    private NoticiaRepositorio noticiaRepositorio;
    
    @Autowired 
    private ImagenServicio imagenServicio;
    
    @Autowired 
    private ImagenRepositorio imagenRepositorio;

    @Autowired 
    private PeriodistaRepositorio periodistaRepositorio;
    
    @Transactional
    public void crearNoticia (String titulo, String cuerpo, MultipartFile archivo, String idPeriodista, List misNoticias) throws MiException{
        
        
         validar(titulo, cuerpo);
    // Asíserí para buscar una notica por id    Noticia noticia = noticiaRepositorio.findById(id).get();      
        
    
       Optional<Periodista> respuestaPeriodista = periodistaRepositorio.findById(idPeriodista);
    
    
        Periodista periodista = new Periodista();
    
         if(respuestaPeriodista.isPresent()){
            
            periodista = respuestaPeriodista.get();
            periodista.setMisNoticias(misNoticias);
        }
        Noticia noticia = new Noticia();
        
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        
        Imagen imagen = imagenServicio.guardarImagen(archivo);
        
        noticia.setImagen(imagen);
        
        noticia.setPeriodista(periodista);

        noticiaRepositorio.save(noticia);
        
        
    }
    
    public List<Noticia> mostrarNoticias(){
        
        List <Noticia> noticias = new ArrayList();
        
        noticias = noticiaRepositorio.findAll();
        
        return noticias;
    }
    
    @Transactional
    public void modificarNoticia(String id, String titulo, String cuerpo, MultipartFile archivo) throws MiException{
        
        
        validar(titulo, cuerpo); 
       Optional<Noticia> respuestaNoticia = noticiaRepositorio.findById(id);  //El optional es por si el id recibido en el formulario esta mal cargado, si el valor de id no lo encuentra 
        
              
       if(respuestaNoticia.isPresent()){
           Noticia noticia = respuestaNoticia.get();
           
           noticia.setTitulo(titulo);
           noticia.setCuerpo(cuerpo);
           
           
           String idImagen = null;
           
           if(noticia.getImagen()!= null){
               idImagen = noticia.getImagen().getId();
           }
           
           Imagen imagen = imagenServicio.modificarImagen(archivo, idImagen);
           
           noticia.setImagen(imagen);
           
           noticiaRepositorio.save(noticia);
       }
        
    }
    
       public Noticia getOne(String id){                        //Pasamos el id y nos retorna el objeto noticia con ese id
           return noticiaRepositorio.getOne(id);
       }
        
              
       public void  eliminarNoticia(String id, String titulo, String cuerpo, MultipartFile archivo) throws MiException{
           
        //   validar(titulo, cuerpo);
           
           Optional<Noticia> respuestaNoticia = noticiaRepositorio.findById(id);
              
           if(respuestaNoticia.isPresent()){
            Noticia noticia = respuestaNoticia.get();
              
             String idImagen = null;
             
               if(noticia.getImagen() != null){
               Imagen imagen = noticia.getImagen();
               idImagen = imagen.getId();
               System.out.println("El número de ID de la imagen es :"+ idImagen);
               imagenServicio.eliminarImagen(archivo, idImagen);
                }
                noticiaRepositorio.deleteById(id); 
           }
           
           
    }       
       
        
       
       public void validar (String titulo, String cuerpo) throws MiException{
           

           if (titulo.isEmpty()){
             throw new MiException("El título no pude ser nulo o esta vacío");  
           }
           if (cuerpo.isEmpty()){
             throw new MiException("El cuerpo no pude ser nulo o esta vacío");
           }
       }
       
       
       
       
       
    }
    
    
    
    

