
package com.egg.biblioteca3.controladores;

import com.egg.biblioteca3.excepciones.MiException;
import com.egg.biblioteca3.servicios.EditorialServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
@RequestMapping("/editorial")    
public class EditorialControladora {
    
    
    @Autowired
    private EditorialServicio editorialServicio;
    
     @GetMapping("/registrar")
     
      public String registrar(){
        return "editorial_form.html";
    }
       @PostMapping("/registro")    //El nombre del registro viene del formulario de html autor_form donde lo declaramos en el action del mismo
    public String registro (@RequestParam String nombre){    
        
         //El parametro que llega a este metodo se llama de la misma manera que pusimos el atributo name de nuestro input en el formulario (línea 71)
        //El @Requestparam es para indicarle al controlador que ese va a ser un parámetro que viaja en ela url
        
        try {

         editorialServicio.crearEditorial(nombre);
           //Si cuando trato de persistir da un error, muestro este por consola y se vuelva a cargar el formulario
        
        } catch (MiException ex) {
            Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE, null, ex);
             return "editorial_form.html";
        }
        
        return "index.html";   //Si sale bien devuelvo el index
    }
            
    }
 


