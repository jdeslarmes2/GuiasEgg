
package utilidades;
import ent.pelicula;
import java.util.Comparator;
public class comparadores {
    
    public static Comparator<pelicula> ordenarDuracion = new Comparator<pelicula> () {
        @Override
        public int compare(pelicula t, pelicula t1) {
            
            return t1.getDuracion().compareTo(t.getDuracion());
            
        }
    };
    
    public static Comparator<pelicula> ordenarDuracionMenor = new Comparator<pelicula> () {
        @Override
        public int compare(pelicula t, pelicula t1) {
            
            return t.getDuracion().compareTo(t1.getDuracion());      //?????????????
            
        }
    };
    public static Comparator<pelicula> ordenarTitulo = new Comparator<pelicula> () {
        @Override
        public int compare(pelicula t, pelicula t1) {
            
            return t.getTitulo().compareTo(t1.getTitulo());     
            
        }
    };
    public static Comparator<pelicula> ordenarDirector = new Comparator<pelicula> () {
        @Override
        public int compare(pelicula t, pelicula t1) {
            
            return t.getDirector().compareTo(t1.getDirector());     
            
        }
    };
    

    
}
