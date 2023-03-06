package com.example.noticias.egg.entidades;

import com.example.noticias.egg.enumeraciones.Rol;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Administrador extends Usuario {



    public Administrador() {
    }

    
    public Administrador(String idAdministrador, String id, String nombreUsuario, String password, Date fechaAlta, Rol rol, Boolean activo, Imagen imagen){
            super(id, nombreUsuario, password, fechaAlta, rol, activo, imagen);
      
    }


     

}
