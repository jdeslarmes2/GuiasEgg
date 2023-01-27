
package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.Plato;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restauranteController {
 
    @PostMapping("/plato")
    public void crearPlato (@RequestBody Plato pla){
        
        System.out.println("Plato creado");
        System.out.println("El ID del plato es: "+ pla.getId());
        System.out.println("El plato es : "+pla.getPlato());
        
    }
    
    @GetMapping ("/plato/platosDelDia")
    @ResponseBody 
    // con linea arrba la devuelve dentro del body o cuerpo
    public List<Plato> mostrarPlatos () {
        
        List<Plato> listaPlatos = new ArrayList<Plato>();
        listaPlatos.add(new Plato(1,"Lasagña a la pomarola"));
        listaPlatos.add(new Plato(2,"Asado con ensalada mixta" ));
        listaPlatos.add(new Plato(3,"Tarta de zapallitos" ));
     
        return listaPlatos;
        //La respuesta lo hace mediante un JSON
    }
     @GetMapping ("/plato/{num1}")
    public String mostrarPlato(@PathVariable int num1){
        
        List<Plato> listaPlatos = new ArrayList<Plato>();
        listaPlatos.add(new Plato(1,"Lasagña a la pomarola"));
        listaPlatos.add(new Plato(2,"Asado con ensalada mixta" ));
        listaPlatos.add(new Plato(3,"Tarta de zapallitos" ));
        
        
        //Recorro por indice
        String respuesta = null;
         for (int i = 0; i < listaPlatos.size(); i++) {
          if (num1 == listaPlatos.get(i).getId()){
            
              respuesta = listaPlatos.get(i).getPlato();
          }
        }
         return respuesta;
    }
}

        
    
    
    

