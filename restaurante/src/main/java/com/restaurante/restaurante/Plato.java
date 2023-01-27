
package com.restaurante.restaurante;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Plato {
    private int id;
    private String plato;
    

    public Plato() {
    }

    public Plato(int id, String plato) {
        this.id = id;
        this.plato = plato;
    }
    
    
    
    
    
}
