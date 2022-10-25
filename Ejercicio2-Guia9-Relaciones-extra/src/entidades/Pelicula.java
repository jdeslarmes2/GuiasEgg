/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author jdeslarmes
 */
public class Pelicula {
    
    private String titulo;
    private Integer edadMinima;
    private Double duracion;
    private String director;

    public Pelicula() {
    }

    public Pelicula(String titulo, Integer edadMinima, Double duracion, String director) {
        this.titulo = titulo;
        this.edadMinima = edadMinima;
        this.duracion = duracion;
        this.director = director;
    }

    public Pelicula(String titulo, Integer edadMinima, String director) {
        this.titulo = titulo;
        this.edadMinima = edadMinima;
        this.director = director;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", edadMinima=" + edadMinima + ", duracion=" + duracion + ", director=" + director + '}';
    }


    
    
}
