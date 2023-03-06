
package com.example.noticias.egg.controladores;


import com.example.noticias.egg.entidades.Administrador;
import com.example.noticias.egg.entidades.Periodista;
import com.example.noticias.egg.entidades.Usuario;
import com.example.noticias.egg.servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminContrtolador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    

    
    @GetMapping("/dashboard")
    public String panelAdministrativo(){
        return "panel.html";                //en este muestra todos los metodos de administrador
    }
    
      @GetMapping("/administradores")
    public String listar(ModelMap modelo) {
        List<Administrador> administradores = usuarioServicio.mostrarAdministradores();
        modelo.addAttribute("administradores", administradores);

        return "administrador_list";
    }
    
    @GetMapping("/modificarRol/{id}")
    public String cambiarRol(@PathVariable String id){
        usuarioServicio.cambiarRol(id);
        
       return "redirect:/admin/usuarios";
    }
    

}
