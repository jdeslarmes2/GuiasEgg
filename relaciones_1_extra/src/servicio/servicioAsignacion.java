package servicio;

import entidad.perro.Perro;
import entidad.persona.Persona;
import java.util.ArrayList;
import java.util.Scanner;


public class servicioAsignacion {
       
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Persona> listaPersonas = new ArrayList();
        ArrayList<Perro> listaPerros = new ArrayList();
        Perro perro = new Perro();
        
    public void crearPersona(){
        Persona p = new Persona();
        
        System.out.println("Ingrese nombre:");
        p.setNombre(leer.next());
        
        System.out.println("Ingrese apellido:");
        p.setApellido(leer.next());
        
        System.out.println("Ingrese edad:");
        p.setEdad(leer.nextInt());
        
        System.out.println("Ingrese DNI");
        p.setDni(leer.nextInt());
        
        listaPersonas.add(p);
            
    }    
    
    public void listaPerro(){
        Perro perro1 = new Perro("Pulgita", 3, "caniche", "mediano");
        listaPerros.add(perro1);
        Perro perro2 = new Perro("Coco", 4, "Salchicha", "pequeño");
        listaPerros.add(perro2);
        Perro perro3 = new Perro("Manchita", 2, "beagle", "mediano");
        listaPerros.add(perro3);
        Perro perro4 = new Perro("Bongo", 2, "pitbull", "grande");
        listaPerros.add(perro4);
        Perro perro5 = new Perro("Rocky", 2, "callejero", "mediano");
        listaPerros.add(perro5);
        
    }

    public void asignarPerro() {
        System.out.println("ADOPTAR");
        System.out.println("Ingrese su nombre:");
        String nombre = leer.next();

        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getNombre().equals(nombre)) {
                System.out.println("Que perro quiere adoptar?");
                for (int j = 0; j < listaPerros.size(); j++) {
                    System.out.println((j + 1) + ". " + listaPerros.get(j).getNombre());
                }

                int opc = leer.nextInt();

                if (listaPerros.get((opc - 1)).isAdoptado() == false) {
                    listaPersonas.get(i).setPerro(listaPerros.get((opc - 1)));
                    listaPerros.get((opc - 1)).setAdoptado(true);
                } else {
                    System.out.println("El perro ya ha sido adoptado");
                    // listaPerros.remove((opc - 1));
                }
            }
        }

    }

    public void mostrarListaPerosna(){
        
        for (Persona aux : listaPersonas) {
            System.out.println(aux);
        }
        
    }
    
    public void mostrarListaPerro(){
        
        for (Perro aux : listaPerros) {
            System.out.println(aux);
        }
        
    }
    
}
