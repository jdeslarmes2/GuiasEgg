package com.example.noticias.egg.controladores;

import com.example.noticias.egg.entidades.Noticia;
import com.example.noticias.egg.entidades.Periodista;
import com.example.noticias.egg.entidades.Usuario;
import com.example.noticias.egg.enumeraciones.Rol;
import com.example.noticias.egg.excepciones.MiException;
import com.example.noticias.egg.repositorios.NoticiaRepositorio;
import com.example.noticias.egg.servicios.UsuarioServicio;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/periodista")
public class ReporterContrtolador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    @GetMapping("/dashboard")
    public String panelPeriodista() {
        return "panel_Periodista.html";                //en este muestra todos los metodos de administrador
    }

    @GetMapping("/periodistas")
    public String listarPeriodista(ModelMap modelo) {
        List<Periodista> periodistas = usuarioServicio.mostrarPeriodistas();
        modelo.addAttribute("periodistas", periodistas);

        return "periodista_list.html";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPeriodista(@PathVariable String id, String nombreUsuario, String password, Date fechaAlta, Rol rol, MultipartFile archivo, List misNoticias, Integer sueldoMensual, ModelMap modelo) {

        try {
            usuarioServicio.eliminarPeriodista(id, nombreUsuario, password, fechaAlta, rol, archivo, misNoticias, sueldoMensual);

            return "periodista_list.html";

        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "periodista_list.html";
        }
    }
    @PreAuthorize("hasRole('ROLE_REPORTER')") 
    @GetMapping("/misNoticias")
    public String verNoticiasPeriodista(ModelMap modelo, HttpSession session) {


            Periodista periodista = (Periodista) session.getAttribute("usuariosession");
            List<Noticia> misNoticias = periodista.getMisNoticias();
            modelo.addAttribute("misNoticias", misNoticias);
            return "periodista_list_id.html";

    }
  

}
