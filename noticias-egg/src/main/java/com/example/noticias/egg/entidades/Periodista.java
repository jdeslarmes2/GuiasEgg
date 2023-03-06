
package com.example.noticias.egg.entidades;


import com.example.noticias.egg.enumeraciones.Rol;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Periodista extends Usuario{
    

    @OneToMany
    private List<Noticia> misNoticias;
    private Integer sueldoMensual;

    public Periodista() {
    }

    public Periodista(String idPeriodista, ArrayList<Noticia> misNoticias, Integer sueldoMensual, String id, String nombreUsuario, String password, Date fechaAlta, Rol rol, Boolean activo, Imagen imagen ) {
        super(id, nombreUsuario, password, fechaAlta, rol, activo, imagen);
        this.misNoticias = misNoticias;
        this.sueldoMensual = sueldoMensual;
    }


    
    public List<Noticia> getMisNoticias() {
        return misNoticias;
    }

    public void setMisNoticias(List<Noticia> misNoticias) {
        this.misNoticias = misNoticias;
    }

    public Integer getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(Integer sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }


    
    
}
