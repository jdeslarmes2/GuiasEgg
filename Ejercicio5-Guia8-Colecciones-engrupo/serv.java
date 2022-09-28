
package serv;
import ent.pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import utilidades.comparadores;

public class serv {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList <pelicula> p = new ArrayList();
    pelicula p1 = new pelicula();
    
    public pelicula cargaPelicula(){
        System.out.println("Ingrese el nombre de la pelicula: ");
        p1.setTitulo(leer.next());
        System.out.println("Ingrese el director de la pelicula: ");
        p1.setDirector(leer.next());
        System.out.println("Ingrese la duracion de la pelicula: ");
        p1.setDuracion(leer.nextDouble());
        pelicula p2 = new pelicula(p1.getTitulo(),p1.getDirector(),p1.getDuracion());
        p.add(p2);
        return p2;
    } //FIN cargaPelicula
    
    public void agregarPeli(){
        String o = " ";
        do{
            System.out.println("Desea cargar otra pelicula? ");
            o = leer.next();
            if (o.equalsIgnoreCase("s")) {
                cargaPelicula();
            } 
        }while(o.equalsIgnoreCase("s"));
    }
    
    public void mostrarPeli(){
        for (pelicula pe : p){
            System.out.println(pe);
        }
    } //FIN mostrarPeli
    
    public void ordenarDuracion(){ 
        System.out.println("Las peliclas de duracion mayor a 1 hora son:");
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getDuracion() > 1) {
              pelicula pel = p.get(i); 
                System.out.println(pel);
        } 
    }
    }//FIN ordenar Duracion
    
    public void ordenarDuracionMayor(){
        System.out.println("Peliculas ordenadas de Mayor a Menor segun su duracion:");
        Collections.sort(p, comparadores.ordenarDuracion); //ordenar el arraylist (se sobreescribe)
        for (pelicula p2 : p) {
            System.out.println(p2);
        }
    }//FIN ordenarMayor
    public void ordenarDuracionMenor(){
        System.out.println("Peliculas ordenadas de Menor a Mayor segun su duracion: ");
        Collections.sort(p, comparadores.ordenarDuracionMenor);
        for (pelicula p2 : p) {
            System.out.println(p2);
        }
        
    }//FIN ordenarMenor
    public void ordenarTitulo(){
        System.out.println("Peliculas ordenadas por TITULO alfabeticamente: ");
        Collections.sort(p, comparadores.ordenarTitulo);
        for (pelicula p2 : p) {
            System.out.println(p2);
        }
    }//FIN ordenarTitulo
    public void ordenarDirectores(){
        System.out.println("Peliculas ordenadas por DIRECTOR alfabeticamente: ");
        Collections.sort(p, comparadores.ordenarDirector);
        for (pelicula p2 : p) {
            System.out.println(p2);
        }
    }
    public void salir(){
        System.out.println("Gracias por su visita!");
        
    }
    public void gral(){
        String opc = " ";
        int op;
        do{
            cargaPelicula();
            System.out.println("Desea continuar la carga?");
            opc = leer.next();
        }while(opc.equalsIgnoreCase("s"));
        do{
        System.out.println("Elija una opcion:");
        System.out.println("1) Mostrar Listado de Peliculas.");
        System.out.println("2) Mostrar Listado de PeliculaS de duracion mayor a 1 hora.");
        System.out.println("3) Mostrar Listado de Peliculas ordenadas de acuerdo a su duracion de Mayor a Menor.");
        System.out.println("4) Mostrar Listado de Peliculas ordenadas de acuerdo a su duracion de Menor a Mayor."); 
        System.out.println("5) Mostrar Listado de Peliculas ordenadas por Titulo alfabeticamente.");
        System.out.println("6) Mostrar Listado de Peliculas ordenadas por Director alfabeticamente.");
        System.out.println("7) Salir del programa.");   
        op = leer.nextInt();
        switch (op){
            case 1:
                mostrarPeli();
                break;
            case 2:
                ordenarDuracion();
                break;
            case 3:
                ordenarDuracionMayor();
                break;
            case 4:
                ordenarDuracionMenor();
                break;
            case 5:
                ordenarTitulo();
                break;
            case 6:
                ordenarDirectores();
                break;
            case 7:
                salir();
                break;
        }
        }while(op != 7);
    }
}//FIN serv
