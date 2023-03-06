package com.example.noticias.egg.controladores;

import com.example.noticias.egg.entidades.Noticia;
import com.example.noticias.egg.entidades.Periodista;
import com.example.noticias.egg.excepciones.MiException;
import com.example.noticias.egg.repositorios.NoticiaRepositorio;
import com.example.noticias.egg.servicios.NoticiaServicio;
import com.example.noticias.egg.servicios.UsuarioServicio;
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
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/noticia")
public class NoticiaControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    @GetMapping("/registrar")
    public String registrar(ModelMap modelo) {

        List<Periodista> periodistas = usuarioServicio.mostrarPeriodistas();

        modelo.addAttribute("periodistas", periodistas);   //LO QUE  VA ENTRE COMILLAS ES EL NOMBRE DE LA LLAVE CON LA QUE VIAJA AL HTML, Y EL PERIODISTAS SIN COMILLAS ES LA LISTA QUE CREAMOS EN LA LINEA ANTERIOR

        return "noticia_form.html";

    }

    @PostMapping("/registro")
    public String registro(@RequestParam String titulo, @RequestParam String cuerpo, @RequestParam MultipartFile archivo, @RequestParam (required=false,name="idPeriodista")String idPeriodista, ModelMap modelo) throws MiException {

        try {

            List<Noticia> misNoticias = null;

            noticiaServicio.crearNoticia(titulo, cuerpo, archivo, idPeriodista, misNoticias);

            misNoticias = noticiaRepositorio.buscarPorId(idPeriodista);
            if (misNoticias != null) {
                usuarioServicio.registrarMisNoticias(idPeriodista, misNoticias);
            }

            modelo.put("exito", "La noticia fue cargada correctamente");

        } catch (MiException ex) {
            List<Periodista> periodistas = usuarioServicio.mostrarPeriodistas();
            modelo.addAttribute("periodistas", periodistas);
            modelo.put("error", ex.getMessage());
            return "noticia_form.html";
        }
        return "index.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {
        List<Noticia> noticias = noticiaServicio.mostrarNoticias();
        modelo.addAttribute("noticias", noticias);

        return "noticia_list.html";
    }

    @GetMapping("/modificar/{id}")             //@Pathvariable me permite que el id viaje a travez de un path en un fragmento de la url (/modificar/{id
    public String modificar(@PathVariable String id, ModelMap modelo) {

        //Ahora debo buscar la noticia con el id por método nuevo que creo en servicio (getone), la idea es que aparezca en la vista la noticia con los datos precargados para poder modificar. 
        modelo.put("noticia", noticiaServicio.getOne(id));         // INYECTO OSEA PRECARGO LOS DATOS DE LA NOTICIA SELECCIONADA

        return "noticia_modificar.html";
    }

    //Ahora hace falta agregar el Postmapping que va a recibir todos los datos del formulario de modificar la noticia
    @PostMapping("/modificar/{id}")
    public String modificarNoticia(@PathVariable String id, String titulo, String cuerpo, MultipartFile archivo, ModelMap modelo) {

        try {
            noticiaServicio.modificarNoticia(id, titulo, cuerpo, archivo);

            return "redirect:../lista";

        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "noticia_modificar.html";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id, String titulo, String cuerpo, MultipartFile archivo, ModelMap modelo) {

        try {
            noticiaServicio.eliminarNoticia(id, titulo, cuerpo, archivo);

            return "redirect:../lista";

        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "noticia_list.html";
        }
    }

}
