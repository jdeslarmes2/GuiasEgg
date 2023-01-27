
package com.integrador1_turista.Integrador1_turista.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Integrador1_turistaController {
    @GetMapping("/convertir/{galones}")
    public String galonesALitros(@PathVariable double galones){
        double litros = galones * 3.78541;
        return "La cantidad de litros de combustible para "+ galones +" galones grandes es de: "+ litros +" lts.";
        
    }
     @GetMapping ("/bye/{nombre}")
    public String sayBye(@PathVariable String nombre){
         return "Bye mundito! esto es una prueba " + nombre;        
        
    }
}
