package com.example.noticias.egg.controladores;

import com.example.noticias.egg.entidades.Administrador;
import com.example.noticias.egg.entidades.Noticia;
import com.example.noticias.egg.entidades.Periodista;
import com.example.noticias.egg.entidades.Usuario;
import com.example.noticias.egg.enumeraciones.Rol;
import com.example.noticias.egg.excepciones.MiException;
import com.example.noticias.egg.repositorios.NoticiaRepositorio;
import com.example.noticias.egg.repositorios.PeriodistaRepositorio;
import com.example.noticias.egg.servicios.NoticiaServicio;
import com.example.noticias.egg.servicios.UsuarioServicio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")                 //cual es la url que va a escuchar a este controllador
public class PortalControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    @GetMapping("/")
    public String index(ModelMap modelo) {

        List<Noticia> noticias = noticiaServicio.mostrarNoticias();
        modelo.addAttribute("noticias", noticias);
        return "index.html";
    }

    @GetMapping("/mostrar/{id}")             //@Pathvariable me permite que el id viaje a travez de un path en un fragmento de la url (/modificar/{id
    public String modificar(@PathVariable String id, ModelMap modelo) {

        //Ahora debo buscar la noticia con el id por método nuevo que creo en servicio (getone), la idea es que aparezca en la vista la noticia con los datos precargados para poder modificar. 
        modelo.put("noticia", noticiaServicio.getOne(id));         // INYECTO OSEA PRECARGO LOS DATOS DE LA NOTICIA SELECCIONADA

        return "noticia.html";
    }

    //------------------------------------------------------------------------------------------------------------
    //---------------------------------------------USUARIO---------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    @GetMapping("/registrar")
    public String registrar() {
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombreUsuario, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaAlta, @RequestParam String password, String password2, @RequestParam Boolean activo, MultipartFile archivo, ModelMap modelo) {

        try {
            usuarioServicio.registrar(archivo, nombreUsuario, password, password2, fechaAlta, activo);
            modelo.put("exito", "Ususario registrado correctamente");   //DECLARACIÖN DE ETIQUETA EXITO LINEA 52 y 58 DE PERIODISTA MODIFICAR.HTML
            return "index.html";
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());         //DECLARACIÖN DE ETIQUETA ERROR
            modelo.put("nombreUsuario", nombreUsuario); //Para dejar precargado el nombre si da error en el password
            modelo.put("fechaAlta", fechaAlta);         //idem a anterior
            return "registro.html";
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {        //el requiered = false es por que es parámetro de entrada puede venir o no con error, y agregar modelo es´para poder agregar error por pantalla 
        if (error != null) {
            modelo.put("error", "Usuario o contraseña invalidos");
        }
        return "login.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN','ROLE_REPORTER')")   //el preautorize es para que solo permita ir a inicio si te logueaste previamente con un role
    @GetMapping("/inicio")
    public String inicio(HttpSession session) {

        Usuario logueado = (Usuario) session.getAttribute("usuariosession");        //usuario session es la llave que tiene todos los datos del usuario logueado seguin el método loadUserByUsername de UsuarioServicio. Se castea "(Usuario)" por que son diferentes tipós de datos y lo debo transformar en tipo usuario

        if (logueado.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        }
        if (logueado.getRol().toString().equals("REPORTER")) {
            return "redirect:/periodista/dashboard";
        } 
        return "inicio.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_REPORTER')")   //el preautorize es para que solo permita ir a inicio si te logueaste previamente con un role
    @GetMapping("/perfil/")                                       //acá no hace falta el id por que tenemos acceso a el mediante la session
    public String perfil(ModelMap modelo, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuariosession");
        modelo.put("usuario", usuario);
        return "usuario_modificar.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_REPORTER')")   //el preautorize es para que solo permita ir a inicio si te logueaste previamente con un role
    @PostMapping("/perfil/{id}")
    public String actualizar(MultipartFile archivo, @PathVariable String idUsuario, @RequestParam String nombreUsuario, @RequestParam Date fechaAlta,
            @RequestParam String password, @RequestParam String password2, @RequestParam Boolean activo, ModelMap modelo) {

        try {
            usuarioServicio.actualizar(archivo, idUsuario, nombreUsuario, password, password2, fechaAlta, activo);

            modelo.put("exito", "Usuario actualizado correctamente!");

            return "inicio.html";
        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombreUsuario", nombreUsuario);
            modelo.put("fechaAlta", fechaAlta);
            modelo.put("archivo", archivo);
            modelo.put("activo", activo);

            return "usuario_modificar.html";
        }
    }

    @GetMapping("/lista/usuario")
    public String listarUsuario(ModelMap modelo) {
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        modelo.addAttribute("usuario", usuarios);

        return "usuario_list.html";
    }

        @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable String id, String nombreUsuario, String password, Date fechaAlta, Rol rol, MultipartFile archivo, ModelMap modelo) {
        
        try {
            usuarioServicio.eliminarUsuario(id, nombreUsuario, password, fechaAlta, rol, archivo);
            
            return "usuario_list.html";
            
        } catch (MiException ex) {
           modelo.put("error", ex.getMessage());
           return "usuario_list.html";
        }
} 
    
    
    
    
    //-----------------------------------------------------------------------------------------------------------------
    //---------------------------------------------PERIODISTA---------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------------
    @GetMapping("/registrarPeriodista")
    public String registrarPeriodista() {
        return "registroPeriodista.html";
    }

    @PostMapping("/registroPeriodista")
    public String registroPeriodista(@RequestParam String nombreUsuario, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaAlta, @RequestParam String password, String password2, @RequestParam Boolean activo, MultipartFile archivo, @RequestParam Integer sueldoMensual, ModelMap modelo) {

        try {
        //    List<Noticia> misNoticias = noticiaRepositorio.buscarPorId(id);
         //   modelo.addAttribute("misNoticias", misNoticias);
            usuarioServicio.registrarPeriodista(archivo, nombreUsuario, password, password2, fechaAlta, activo, sueldoMensual);
            modelo.put("exito", "Periodista registrado correctamente");
            return "index.html";
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            modelo.put("nombreUsuario", nombreUsuario); //Para dejar precargado el nombre si da error en el password
            modelo.put("fechaAlta", fechaAlta);         //idem a anterior
            modelo.put("archivo", archivo);
            modelo.put("activo", activo);
            modelo.put("sueldoMensual", sueldoMensual);
            return "registroPeriodista.html";
        }
    }


    @GetMapping("/perfilPeriodista/{id}")                                       //acá no hace falta el id por que tenemos acceso a el mediante la session
    public String perfilPeriodista(@PathVariable String id, ModelMap modelo){
        Periodista periodista = usuarioServicio.getOnePeriodista(id);
        modelo.put("periodista", periodista);
        return "periodista_modificar.html";
    }

  //el preautorize es para que solo permita ir a inicio si te logueaste previamente con un role
    @PostMapping("/perfilPeriodista/{id}")
    public String actualizarPeriodista(MultipartFile archivo, @PathVariable String id, @RequestParam String nombreUsuario, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaAlta,
            @RequestParam String password, @RequestParam String password2, @RequestParam Boolean activo, Integer sueldoMensual, ModelMap modelo) {
            


        try {

            usuarioServicio.actualizarPeriodista(archivo, id, nombreUsuario, password, password2, fechaAlta, activo, sueldoMensual);

            modelo.put("exito", "Periodista actualizado correctamente!");

            return "inicio.html";
        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombreUsuario", nombreUsuario);
            modelo.put("fechaAlta", fechaAlta);
            modelo.put("archivo", archivo);
            modelo.put("activo", activo);
            modelo.put("sueldoMensual", sueldoMensual);


            return "periodista_modificar.html";
        }
    }


    
    //-------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------ADMINISTRADOR---------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------------------

    @GetMapping("/registrarAdministrador")
    public String registrarAdministrador() {
        return "registroAdministrador.html";
    }

    @PostMapping("/registroAdministrador/{id}")
    public String registroAdministrador(@RequestParam String nombreUsuario, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaAlta, @RequestParam String password, String password2, @RequestParam Boolean activo, MultipartFile archivo, ModelMap modelo) {

        try {
            usuarioServicio.registrar(archivo, nombreUsuario, password, password2, fechaAlta, activo);
            modelo.put("exito", "Ususario registrado correctamente");
            return "index.html";
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            modelo.put("nombreUsuario", nombreUsuario); //Para dejar precargado el nombre si da error en el password
            modelo.put("fechaAlta", fechaAlta);         //idem a anterior
            modelo.put("archivo", archivo);
            modelo.put("activo", activo);

            return "registroAdministrador.html";
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_REPORTER')")   //el preautorize es para que solo permita ir a inicio si te logueaste previamente con un role
    @GetMapping("/perfilAdministrador")                                       //acá no hace falta el id por que tenemos acceso a el mediante la session
    public String perfilAdministardor(ModelMap modelo, HttpSession session) {
        Administrador administrador = (Administrador) session.getAttribute("usuariosession");
        modelo.put("administrador", administrador);
        return "administrador_modificar.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_REPORTER')")   //el preautorize es para que solo permita ir a inicio si te logueaste previamente con un role
    @PostMapping("/perfilAdministrador/{id}")
    public String actualizarAdministrador(MultipartFile archivo, @PathVariable String idUsuario, @RequestParam String nombreUsuario, @RequestParam Date fechaAlta,
            @RequestParam String password, @RequestParam String password2, @RequestParam Boolean activo, ModelMap modelo) {

        try {
            usuarioServicio.actualizarAdministrador(archivo, idUsuario, nombreUsuario, password, password2, fechaAlta, activo);

            modelo.put("exito", "Administrador actualizado correctamente!");

            return "inicio.html";
        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombreUsuario", nombreUsuario);
            modelo.put("fechaAlta", fechaAlta);
            modelo.put("archivo", archivo);
            modelo.put("activo", activo);

            return "administrador_modificar.html";
        }
    }

}
