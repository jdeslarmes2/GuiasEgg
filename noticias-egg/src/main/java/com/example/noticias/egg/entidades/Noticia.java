
package com.example.noticias.egg.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Noticia {

    
    @Id
    @GeneratedValue(generator = "uuid") //Genera id en forma automatica al momento que el repositorio persista la entidad
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String titulo;
    @Column(length = 3000) 
    private String cuerpo;

    
    @ManyToOne
    private Periodista periodista;

    public Periodista getPeriodista() {
        return periodista;
    }

    public void setPeriodista(Periodista periodista) {
        this.periodista = periodista;
    }
    
    
    @OneToOne  //El cascade es para que borre la imagen cuando borro la noticia, intente también con , mappedBy = "noticia", no funciono. (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "noticia")(cascade = CascadeType.ALL)
    private Imagen imagen;

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    
    public Noticia() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    
    
    
    
    
}


