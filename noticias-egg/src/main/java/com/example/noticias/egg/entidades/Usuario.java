
package com.example.noticias.egg.entidades;

import com.example.noticias.egg.enumeraciones.Rol;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(generator = "uuid") //Genera id en forma automatica al momento que el repositorio persista la entidad
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    public String nombreUsuario;

    private String password;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaAlta;
            
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
    private Boolean activo;
    
    @OneToOne
    private Imagen imagen;

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public Usuario() {
    }

    public Usuario(String id, String nombreUsuario, String password, Date fechaAlta, Rol rol, Boolean activo, Imagen imagen) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.fechaAlta = fechaAlta;
        this.rol = rol;
        this.activo = activo;
        this.imagen = imagen;
    }
    
    
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
}
