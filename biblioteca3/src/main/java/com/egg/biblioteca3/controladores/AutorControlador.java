
package com.egg.biblioteca3.controladores;

import com.egg.biblioteca3.entidades.Autor;
import com.egg.biblioteca3.excepciones.MiException;
import com.egg.biblioteca3.servicios.AutorServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller 
@RequestMapping("/autor")          //localhost:8081/autor
public class AutorControlador {
    
    @Autowired
    private AutorServicio autorServicio;
    
    @GetMapping("/registrar") //localhost:8081/autor/regisrar
    
    public String registrar(){
        return "autor_form.html";
    }
       
    @PostMapping("/registro")    //El nombre del registro viene del formulario de html autor_form donde lo declaramos en el action del mismo
    public String registro (@RequestParam String nombre, ModelMap modelo){    
        
         //El parametro que llega a este metodo se llama de la misma manera que pusimos el atributo name de nuestro input en el formulario (línea 71)
        //El @Requestparam es para indicarle al controlador que ese va a ser un parámetro que viaja en ela url
        
        try {

        autorServicio.crearAutor(nombre);  //Si cuando trato de persistir da un error, muestro este por consola y se vuelva a cargar el formulario
        modelo.put("exito", "El autor fue registrado correctamente");
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
             return "autor_form.html";
        }
        
        return "index.html";   //Si sale bien devuelvo el index
    }
   
    @GetMapping("/lista")                    //metodo para crear lista de autores
    public String listar (ModelMap modelo){
            
            List <Autor> autores = autorServicio.listarAutores();
            modelo.addAttribute("autores", autores);
            
            return "autor_list.html";           
            
   } 
    
    //En la modificación hago un getmapping para obtener el id, y un postmapping para hacer efectiva la modificación en la tabla
    
    @GetMapping("/modificar/{id}")                  // Path variable es una notacion que sirve para decir que esa info viaja por medio de un path, oseaa travez de un fragmento de la url donde se encuentra determinado recurso
    public String modificar (@PathVariable String id, ModelMap modelo){
         modelo.put("autor", autorServicio.getOne(id));             // cuando se renderice la vista de los datos que quiero modificar ya vengan recargados con el id al que yo quiero modificar, para eso uso el método que creo de getone en autor Servicio
    
         return "autor_modificar.html";
}
    @PostMapping("/modificar/{id}")
    public String modificar (@PathVariable String id, String nombre, ModelMap modelo){
        try {
            autorServicio.modificarAutor(nombre, id);
            
            return  "redirect:../lista";
            
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return  "autor_modificar.html";
        }
        
    }
    
}