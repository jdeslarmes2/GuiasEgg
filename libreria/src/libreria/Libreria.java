
package libreria;

import libreria.entidades.Libro;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;


public class Libreria {


    public static void main(String[] args) throws Exception  {
      
    LibroServicio ls = new LibroServicio();
    AutorServicio as = new AutorServicio();
    EditorialServicio es = new EditorialServicio();
    
    
    //--------------------------------TABLA LIBRO -------------------------------------------------------
    
      //Ejercicio 1 punto 7
          //Crear objeto libro en DB 
          //Libro libro = ls.crearLibro();
          //ls.crearlibroDB(libro);
          
          //Consultar objeto libro en DB 
          
    //      Libro libro2 = ls.consultarlibroDB(3);
    //      System.out.println(libro2.toString());
          
    //      Modificar objeto libro en DB
    //      Libro libro3 = ls.crearLibro(null, null); //Este libro tienen que tener el mismo ID = 2
    //      ls.modificarlibroDB(libro3);
          
     //    Eliminar objeto libro en DB
     //     ls.eliminarlibroDB(2);
          
      // Ejercicio 1 punto 10

      //    ls.mostrarLibroNombre();

      //Simil Ejercicio 1 punto 11
      
      //  ls.mostrarLibrosEjemplares();
      
      //Editar o nombre o año de un libro    
      //    ls.editarParametroLibro();
      
      //Eliminar libro por nombre
      //    ls.eliminarLibroNombre();
       
     // Ejercicio 1 punto 11
     //  ls.mostrarLibroPorAutor();
     
     // -----------------------------TABLA AUTOR--------------------------------------------
     
     //Crear un autor
     //as.crearAutorDB();
     
     // -----------------------------TABLA EDITORIAL--------------------------------------------
     
     //Mostrar por Editorial
     es.mostrarLibroPorEditorial(); 
      
      
      
      
    } 
    

    
    
}
