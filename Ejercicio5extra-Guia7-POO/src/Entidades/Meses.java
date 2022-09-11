/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author jdeslarmes
 */
public class Meses {
    
    private String [] mes = {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
    private String mesSecreto = mes[9];
    private String mesElegido;

    public Meses() {
    }

    public Meses(String mesElegido) {
        this.mesElegido = mesElegido;
    }

    public String[] getMes() {
        return mes;
    }

    public String getMesSecreto() {
        return mesSecreto;
    }

    public String getMesElegido() {
        return mesElegido;
    }

    public void setMesElegido(String mesElegido) {
        this.mesElegido = mesElegido;
    }



    
    
}
