package relaciones_1;

import java.util.Scanner;
import servicio.servicioAsignacion;

public class Relaciones_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        servicioAsignacion serv = new servicioAsignacion();
        
        serv.listaPerro();
        
        for (int i = 0; i < 5; i++){
            serv.crearPersona();
        }
        
        for (int i = 0; i < 5; i++) {
            serv.asignarPerro();
        }
        
        serv.mostrarListaPerosna();
        serv.mostrarListaPerro();
    }

}
