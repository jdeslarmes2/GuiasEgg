
package com.egg.biblioteca3.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;


 @Entity
public class Autor {
    
     @Id
     @GeneratedValue(generator = "uuid") //Genera id en forma automatica al momento que el repositorio persista la entidad
     @GenericGenerator(name = "uuid", strategy = "uuid2") //De esta manera nos aseguramos que el id nunca se repita, esto genera una cadena de texto alfanumerica única.
     private String id;
     private String nombre;

    public Autor() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    
    
}
