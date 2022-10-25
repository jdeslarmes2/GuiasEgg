/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Alumno;
import entidad.Voto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import numeracion.Apellidos;
import numeracion.Nombres;

/**
 *
 * @author LMACHADO
 */
public class Simulador {

    Voto voto = new Voto();
    ArrayList<Nombres> nombres = new ArrayList(Arrays.asList(Nombres.values()));
    ArrayList<Apellidos> apellidos = new ArrayList(Arrays.asList(Apellidos.values()));
    ArrayList<Alumno> alumnos = new ArrayList<>();
    HashSet <Voto> votados = new HashSet <>();

    public void crearAlumno() {

        Collections.shuffle(nombres);
        Collections.shuffle(apellidos);

        for (int i = 0; i < 10; i++) {

            alumnos.add(new Alumno((nombres.get(i).toString() + " " + apellidos.get(i).toString()), (int) (Math.random() * (40000000 - 30000000) + 30000000), 0));
        }

//        for (Alumno nombre : alumnos) {
//            System.out.println(nombre);
//        }
    }

    public void votacion() {
        
        for (int i = 0; i < 10; i++) {
            
            Alumno votante = alumnos.get(i);
            int [] votos = {10,10,10};
            
            for (int j = 0; j < 3; j++) {
                
                int posicion = (int) (Math.random() * 9);
                
                while (posicion == i || votos[0] == posicion || votos[1] == posicion || votos[2] == posicion) {
                    posicion = (int) (Math.random() * 9);
                }
                alumnos.get(posicion).setVotosRecibidos(alumnos.get(posicion).getVotosRecibidos() + 1);
                votos[j]=posicion;
                
               // System.out.println(posicion);
            }
            
        }
        
        
        for (Alumno nombre : alumnos) {
            System.out.println(nombre);
        }

    }

}
