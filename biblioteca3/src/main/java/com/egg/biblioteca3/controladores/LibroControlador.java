
package com.egg.biblioteca3.controladores;

import com.egg.biblioteca3.entidades.Autor;
import com.egg.biblioteca3.entidades.Editorial;
import com.egg.biblioteca3.entidades.Libro;
import com.egg.biblioteca3.entidades.repositorios.EditorialRepositorio;
import com.egg.biblioteca3.excepciones.MiException;
import com.egg.biblioteca3.servicios.AutorServicio;
import com.egg.biblioteca3.servicios.LibroServicios;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.egg.biblioteca3.servicios.EditorialServicio;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/libro") 
public class LibroControlador {
    
    
    @Autowired
    private LibroServicios libroServicio;
    
    @Autowired
    private AutorServicio autorServicio;
    
    @Autowired
    private EditorialServicio editorialServicio;
    
    @GetMapping("/registrar") //localhost:8081/autor/registrar  
    public String registrar(ModelMap modelo){
        List<Autor> autores = autorServicio.listarAutores();
        List<Editorial> editoriales = editorialServicio.listarEditoriales(); //Después anclar esto para que se vea en la interface de usuario.
                
        modelo.addAttribute("autores", autores);   //enviamos al modelo bajo la llave autores, le cargo la lista que acabamos de rellenar
        modelo.addAttribute("editoriales", editoriales);
        
        
        return "libro_form.html";
    }
    
     @PostMapping("/registro")    //El nombre del registro viene del formulario de html libro_form donde lo declaramos en el action del mismo
    public String registro (@RequestParam(required=false) Long isbn, @RequestParam String titulo,  //COn el required = false evito para todo parametro numerico que venga nuelo que no entre en el controlador y luego manejar la excepción internamente, cuando no lo pongo se rompe y no entra al controlador.
            @RequestParam(required=false) Integer ejemplares, @RequestParam String idAutor,
            @RequestParam String idEditorial, ModelMap modelo){    //Los modelos sirven para inserttar toda la información que necesitamos ver en pantalla, en este caso la pantalla del usuario para enviarle el mensaje de error cuando un  parametro es nulo 
    
        try {
            libroServicio.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
            modelo.put("exito", "El libro fue cargado correctamente");
            
        } catch (MiException ex) {
        List<Autor> autores = autorServicio.listarAutores();
        List<Editorial> editoriales = editorialServicio.listarEditoriales(); //Después anclar esto para que se vea en la interface de usuario.
                
        modelo.addAttribute("autores", autores);   //enviamos al modelo bajo la llave autores, le cargo la lista que acabamos de rellenar
        modelo.addAttribute("editoriales", editoriales);
            modelo.put("error", ex.getMessage());   //Pongo el texto que habíamos puestop en nuestra validación
            return "libro_form.html";
        }
    return "index.html";
   }    
    @GetMapping("/lista")
    public String listar(ModelMap modelo){
        System.out.println("Prueba");
        List<Libro> libros = libroServicio.listarLibros();
        modelo.addAttribute("libros", libros);
        
        return "libro_list";
    }
  
 }