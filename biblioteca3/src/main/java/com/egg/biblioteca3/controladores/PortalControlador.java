
package com.egg.biblioteca3.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")     //@RequestMapping indica cual es la url que va a escuchar a este controlador  (empezamos a unir HTML con los servicios . Cuando en mi local host pongamos una "/" algo este controlador se va a activar.
public class PortalControlador {
    
    @GetMapping("/")
    public String index(){
 
       return "index.html";    //Acá devolvemos la vista que queremos que se renderice (generacióin de imagen) una vez quw se entra la barra. Si luego de pararme en el proyecto y dar run, levanta el spring y pongo la barra en el local hosts y vemos mensaje entonces tenemos la primer clase controladora mapeada al HTML
    }
     @GetMapping("/registrar")
    public String registrar(){
        return "registro.html";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login.html";
    }
    
}
