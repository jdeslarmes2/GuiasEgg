/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Baraja;
import entidades.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class servicioBaraja {

    Scanner leer = new Scanner(System.in);
    servicioCarta sc = new servicioCarta();
    ArrayList<Carta> cartas = new ArrayList();
    ArrayList<Carta> cartasEntregadas = new ArrayList();
    Carta c1 = new Carta();
    Baraja b1 = new Baraja();

    public void crearBaraja() {

        //Creo espadas y las cargo en el maso
        int palos = 0;
        int contador = 0;
        for (int a = 0; a < 3; a++) {
            palos++;
            if (palos == 1) {
                c1.setPalo("Espadas");
            }
            if (palos == 2) {
                c1.setPalo("Oros");
            }
            if (palos == 3) {
                c1.setPalo("Bastos");
            }
            if (palos == 4) {
                c1.setPalo("Copas");
            }
            for (int i = 0; i < 11; i++) {
                contador++;
                c1.setNumero(contador);
                sc.mostrarCarta(c1);
                cartas.add(contador, c1);
            }
        }

        //Elimino los 8 y 9 (si hicieramos con ArrayList)
        Iterator<Carta> it = cartas.iterator();
        while (it.hasNext()) {
            if (it.next().getNumero() == 8 || it.next().getNumero() == 9) {
                it.remove();
            }
        }
        //Mostrar ArrayList barajas de maso final (si hicieramos con ArrayList la lista)

        for (Carta aux : cartas) {
            System.out.println(aux.toString());
        }

        //Elimino los 8 y 9 (con HashMap por que me da el indice que necesito después para desordenar datos"
        //   cartas.remove(8);   
        //   cartas.remove(9);   
        //  Mostrar Mapa barajas de maso final
        // entry.getKey trae la llave y entry.getValue trae los valores del mapa, Es decir todos sus atributos
        //  for (Map.Entry<Integer, Carta> entry : cartas.entrySet()) {
        //     System.out.println("Indice=" + entry.getKey() + ", Datos de la carta" + entry.getValue());
        //}
        // Cargo el objeto Baraja (si hicieramos con ArrayList la lista)
        b1.setCartas(cartas);
    }

    public void barajar() {

        ArrayList<Carta> barajadas = b1.getCartas();
        //Desordeno aleatoriamente la 
        Collections.shuffle(barajadas);

        //Cargo el objeto baraja desordenado aleatoriamente
        b1.setCartas(barajadas);

        //Muestro la cartas barajadas cargadas y desordenadas aleatoriamente
        for (Carta aux : b1.getCartas()) {
            System.out.println(aux.toString());
        }

    }

    public void siguienteCarta() {

        //Si no tengo una sola carta del maso aviso que no hay más cartas
        int ultimaCarta = b1.getCartas().size();

        if (ultimaCarta == 0) {
            System.out.println("Usted no tiene más cartas en el maso");
        }

        if (ultimaCarta > 0) {

            //Muestro carta del maso, no importa el tamaño del mismo
            Carta cartaSeleccionada = new Carta();
            for (int i = 0; i < b1.getCartas().size(); i++) {
                cartaSeleccionada = b1.getCartas().get(i);
                sc.mostrarCarta(cartaSeleccionada);
                break;
            }
            //Borro carta seleccionada del maso
            Iterator<Carta> it = cartas.iterator();
            while (it.hasNext()) {
                if (it.next().equals(cartaSeleccionada)) { // Si se cumple la condicion de encontrar se elimina la carta
                    cartasEntregadas.add(cartaSeleccionada);
                    it.remove();
                }
            }
        }
        //Agrego ArrayList de cartas entregadas a objeto CartasEntregadas
        b1.setCartasEntregadas(cartasEntregadas);
    }

    public void cartasDisponibles() {

        int cartasDisponibles = b1.getCartas().size();

        if (cartasDisponibles == 0) {
            System.out.println("Usted no tiene más cartas en el maso");
        }

        while (cartasDisponibles > 0) {

            System.out.println("Las cartas disponibles para repartir son: " + b1.getCartas().size());
        }
    }

    public void darCartas() {
        ArrayList<Carta> cartasRepartidas = new ArrayList(); 
        System.out.println("Ingrese el número de cartas que desea repartir: ");
        int cartasARepartir = leer.nextInt();

        if (cartasARepartir > b1.getCartas().size()) {
            System.out.println("Usted no tiene suficientes cartas en el mazo para repartir esa cantidad");
        } else {

            //Muestro cartas del maso a repartir
            
            Carta cartaSeleccionada = new Carta();
            for (int i = 0; i < cartasARepartir; i++) {
                cartaSeleccionada = b1.getCartas().get(i);
                sc.mostrarCarta(cartaSeleccionada);
                cartasEntregadas.add(cartaSeleccionada);

                //Borro del maso de cartas la carta seleccionada en el mismo for
                Iterator<Carta> it = cartas.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(cartaSeleccionada)) { // Si se cumple la condicion de encontrar se elimina la carta
                        it.remove();
                    }
                }
            }
        }
    // Agrego nuevas cartas Lista de cartas entregadas al objeto cartas entregadas de la clase baraja (¿¿¿pisa todas las lineas del arraylist o solo agrega las nuevas???)
    b1.setCartasEntregadas(cartasEntregadas);
    }

    public void cartasMonton() {

        if (cartasEntregadas.size() == 0) {
            System.out.println("Usted no ha entregado ninguna carta");
        } else {
            Carta cartaSeleccionada = new Carta();
            System.out.println("Las cartas del montón de entregadas son: ");
            for (int i = 0; i < cartasEntregadas.size(); i++) {
                cartaSeleccionada = b1.getCartasEntregadas().get(i);
                sc.mostrarCarta(cartaSeleccionada);
            }
        }

    }
    
    public void mostrarBaraja(){
        
        Carta cartaSeleccionada = new Carta();
            System.out.println("Las cartas del maso son : ");
            for (int i = 0; i < b1.getCartas().size(); i++) {
                cartaSeleccionada = b1.getCartas().get(i);
                sc.mostrarCarta(cartaSeleccionada);
            }
        
    }
    
    
    
}
