package com.example.noticias.egg.servicios;

import com.example.noticias.egg.entidades.Administrador;
import com.example.noticias.egg.entidades.Imagen;
import com.example.noticias.egg.entidades.Noticia;
import com.example.noticias.egg.entidades.Periodista;
import com.example.noticias.egg.entidades.Usuario;
import com.example.noticias.egg.enumeraciones.Rol;
import com.example.noticias.egg.excepciones.MiException;
import com.example.noticias.egg.repositorios.AdministradorRepositorio;
import com.example.noticias.egg.repositorios.NoticiaRepositorio;
import com.example.noticias.egg.repositorios.PeriodistaRepositorio;
import com.example.noticias.egg.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PeriodistaRepositorio periodistaRepositorio;

    @Autowired
    private AdministradorRepositorio administradorRepositorio;

    @Autowired
    private ImagenServicio imagenServicio;

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    @Transactional
    public void registrar(MultipartFile archivo, String nombreUsuario, String password, String password2, Date fechaAlta, Boolean activo) throws MiException {

        validar(nombreUsuario, password, password2);

        Usuario usuario = new Usuario();

        usuario.setNombreUsuario(nombreUsuario);

        usuario.setPassword(new BCryptPasswordEncoder().encode(password));

        usuario.setFechaAlta(fechaAlta);

        usuario.setActivo(activo);

        usuario.setRol(Rol.USER);

        Imagen imagen = imagenServicio.guardarImagen(archivo);

        usuario.setImagen(imagen);

        usuarioRepositorio.save(usuario);
    }

    @Transactional
    public void actualizar(MultipartFile archivo, String idUsuario, String nombreUsuario, String password, String password2, Date fechaAlta, Boolean activo) throws MiException {

        validar(nombreUsuario, password, password2);

        Optional<Usuario> respuesta = usuarioRepositorio.findById(idUsuario);

        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();

            usuario.setNombreUsuario(nombreUsuario);

            usuario.setPassword(new BCryptPasswordEncoder().encode(password));

            usuario.setFechaAlta(fechaAlta);

            usuario.setActivo(activo);

            usuario.setRol(Rol.USER);

            String idImagen = null;

            if (usuario.getImagen() != null) {
                idImagen = usuario.getImagen().getId();
            }

            Imagen imagen = imagenServicio.modificarImagen(archivo, idImagen);

            usuario.setImagen(imagen);

            usuarioRepositorio.save(usuario);
        }

    }

    public Usuario getOne(String id) {                        //Pasamos el id y nos retorna el objeto noticia con ese id
        return usuarioRepositorio.getOne(id);
    }
    
    public Periodista getOnePeriodista(String id) {                       
        return periodistaRepositorio.getOne(id);
    }
    

    @Transactional                                     //falta (readOnly=true)
    public List<Usuario> listarUsuarios() {

        List<Usuario> usuarios = new ArrayList();

        usuarios = usuarioRepositorio.findAll();

        return usuarios;
    }

    @Transactional
    public void cambiarRol(String id) {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();

            if (usuario.getRol().equals(Rol.USER)) {

                usuario.setRol(Rol.ADMIN);

            } else if (usuario.getRol().equals(Rol.ADMIN)) {
                usuario.setRol(Rol.USER);
            }
            if (usuario.getRol().equals(Rol.REPORTER)) {

                usuario.setRol(Rol.ADMIN);

            }
        }
    }

    private void validar(String nombreUsuario, String password, String password2) throws MiException {

        if (nombreUsuario.isEmpty() || nombreUsuario == null) {
            throw new MiException("El nombre de usuario no puede ser nulo o estar vació");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no pueda esta vacia, y debe tener más de 5 dígitos");
        }
        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.buscarPorNombre(nombreUsuario);

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());

            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();                        //Inserto una llamada para atrapar a ese usuario que ya esta autenticado y guardarlo en la sesion web.  La llamada recupera los atributos de request, osea de la solicitud http

            HttpSession session = attr.getRequest().getSession(true);  //Objeto de la interface httpsession

            session.setAttribute("usuariosession", usuario);        //seteamos el atributo usuariosession como llave que va a tener el valor con todos los daros de usuario autenticado

            return new User(usuario.getNombreUsuario(), usuario.getPassword(), permisos);

            //OJO cuando importamos USER debe ser import org.springframework.security.core.userdetails.User, sino no permite agregar los permisos con GarantedAuthority ni asignarle un role como explica enh el video 3, ya que user aparece sin atributos necesarios.
        } else {
            return null;
        }
    }

    public List<Periodista> mostrarPeriodistas() {

        List<Periodista> periodistas = new ArrayList();

        periodistas = periodistaRepositorio.findAll();

        return periodistas;
    }

    @Transactional
    public void registrarPeriodista(MultipartFile archivo, String nombreUsuario, String password, String password2, Date fechaAlta, Boolean activo, Integer sueldoMensual) throws MiException {

        validar(nombreUsuario, password, password2);

        Periodista periodista = new Periodista();

        periodista.setNombreUsuario(nombreUsuario);

        periodista.setPassword(new BCryptPasswordEncoder().encode(password));

        periodista.setFechaAlta(fechaAlta);

        periodista.setActivo(activo);

        periodista.setRol(Rol.REPORTER);

        Imagen imagen = imagenServicio.guardarImagen(archivo);

        periodista.setImagen(imagen);

        periodista.setSueldoMensual(sueldoMensual);

        //    periodista.setMisNoticias(misNoticias);
        periodistaRepositorio.save(periodista);
    }

    @Transactional
    public void actualizarPeriodista(MultipartFile archivo, String idUsuario, String nombreUsuario, String password, String password2, Date fechaAlta, Boolean activo, Integer sueldoMensual) throws MiException {

        validar(nombreUsuario, password, password2);

        Optional<Periodista> respuesta = periodistaRepositorio.findById(idUsuario);

        if (respuesta.isPresent()) {

            Periodista periodista = respuesta.get();

            periodista.setNombreUsuario(nombreUsuario);

            periodista.setPassword(new BCryptPasswordEncoder().encode(password));

            periodista.setFechaAlta(fechaAlta);

            periodista.setActivo(activo);

            periodista.setRol(Rol.REPORTER);

            String idImagen = null;

            if (periodista.getImagen() != null) {
                idImagen = periodista.getImagen().getId();
            }

            Imagen imagen = imagenServicio.modificarImagen(archivo, idImagen);

            periodista.setImagen(imagen);

            periodista.setSueldoMensual(sueldoMensual);


            periodistaRepositorio.save(periodista);
        }

    }
    
    
    @Transactional
    public void registrarMisNoticias (String idPeriodista, List misNoticias){
        

        Optional<Periodista> respuesta = periodistaRepositorio.findById(idPeriodista);
        
          if (respuesta.isPresent()) {

            Periodista periodista = respuesta.get();
            
            periodista.setMisNoticias(misNoticias);
            
             periodistaRepositorio.save(periodista);
         }
        
    }
    
    
    
    
    
    

    @Transactional
    public void registrarAdministrador(MultipartFile archivo, String nombreUsuario, String password, String password2, Date fechaAlta, Boolean activo, ArrayList misNoticias, Integer sueldoMensual) throws MiException {

        validar(nombreUsuario, password, password2);

        Periodista periodista = new Periodista();

        periodista.setNombreUsuario(nombreUsuario);

        periodista.setPassword(new BCryptPasswordEncoder().encode(password));

        periodista.setFechaAlta(fechaAlta);

        periodista.setActivo(activo);

        periodista.setRol(Rol.ADMIN);

        Imagen imagen = imagenServicio.guardarImagen(archivo);

        periodista.setImagen(imagen);

        periodista.setSueldoMensual(sueldoMensual);

        periodista.setMisNoticias(misNoticias);

        periodistaRepositorio.save(periodista);
    }

    @Transactional
    public void actualizarAdministrador(MultipartFile archivo, String idUsuario, String nombreUsuario, String password, String password2, Date fechaAlta, Boolean activo) throws MiException {

        validar(nombreUsuario, password, password2);

        Optional<Administrador> respuesta = administradorRepositorio.findById(idUsuario);

        if (respuesta.isPresent()) {

            Administrador administrador = respuesta.get();

            administrador.setNombreUsuario(nombreUsuario);

            administrador.setPassword(new BCryptPasswordEncoder().encode(password));

            administrador.setFechaAlta(fechaAlta);

            administrador.setActivo(activo);

            administrador.setRol(Rol.ADMIN);

            String idImagen = null;

            if (administrador.getImagen() != null) {
                idImagen = administrador.getImagen().getId();
            }

            Imagen imagen = imagenServicio.modificarImagen(archivo, idImagen);

            administrador.setImagen(imagen);

            administradorRepositorio.save(administrador);
        }

    }

    public void eliminarUsuario(String id, String nombreUsuario, String password, Date fechaAlta, Rol rol, MultipartFile archivo) throws MiException {

        //   validar(titulo, cuerpo);
        Optional<Usuario> respuestaUsuario = usuarioRepositorio.findById(id);

        if (respuestaUsuario.isPresent()) {
            Usuario usuario = respuestaUsuario.get();

            String idImagen = null;
            if (usuario.getImagen() != null) {
                idImagen = usuario.getImagen().getId();
                imagenServicio.eliminarImagen(archivo, idImagen);
            }

            usuarioRepositorio.deleteById(id);

        }

    }

    public void eliminarPeriodista(String id, String nombreUsuario, String password, Date fechaAlta, Rol rol, MultipartFile archivo, List misNoticias, Integer sueldoMensual) throws MiException {

        //   validar(titulo, cuerpo);
        Optional<Periodista> respuestaPeriodista = periodistaRepositorio.findById(id);

        if (respuestaPeriodista.isPresent()) {
            Periodista periodista = respuestaPeriodista.get();

            String idImagen = null;
            if (periodista.getImagen() != null) {
                idImagen = periodista.getImagen().getId();
                imagenServicio.eliminarImagen(archivo, idImagen);
            }

            periodistaRepositorio.deleteById(id);
        }

    }
        public List<Administrador> mostrarAdministradores() {

        List<Administrador> administradores = new ArrayList();

        administradores = administradorRepositorio.findAll();

        return administradores;
    }
         
        public void eliminarAdministrador(String id, String nombreUsuario, String password, Date fechaAlta, Rol rol, MultipartFile archivo) throws MiException {

        //   validar(titulo, cuerpo);
        Optional<Administrador> respuestaAdministrador = administradorRepositorio.findById(id);

        if (respuestaAdministrador.isPresent()) {
            Administrador administrador = respuestaAdministrador.get();

            String idImagen = null;
            if (administrador.getImagen() != null) {
                idImagen = administrador.getImagen().getId();
                imagenServicio.eliminarImagen(archivo, idImagen);
            }

            administradorRepositorio.deleteById(id);
        }  
      }    
}
