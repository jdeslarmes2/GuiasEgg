/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Etiquetas.Cadena;
import java.util.Scanner;

/**
 *
 * @author jdeslarmes
 */
public class CadenaServicio {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");  
    
    public Cadena crearCadena(){
        
        
        Cadena c1 = new Cadena();
        
        System.out.println("Ingrese la frase a verificar: ");
        c1.setFrase(leer.nextLine());
  //      String Frase = (c1.getFrase());
        c1.setLongitud(c1.getFrase().length());
        System.out.println(c1.toString());
        
        return c1;
        
        
    }
    
    
    public void mostrarVocales(Cadena c1){
        
        int i;
        int vocales = 0;
        
        String Frase = c1.getFrase().toUpperCase();
        
        System.out.println("Su frase es: " + Frase);
       
       for (i = 1; i < Frase.length()+ 1 ; i++){
           if (Frase.substring(i-1,i).equals("A") || Frase.substring(i-1,i).equals("E") || Frase.substring(i-1,i).equals("I") || Frase.substring(i-1,i).equals("O") || Frase.substring(i-1,i).equals("U")){
               vocales = vocales +1;
           
            }     
        }
        System.out.println("El número de vocales es: " + vocales);    
    
    }

    
    public void invertirFrase (Cadena c1){
        
        
        //Asigno indices numéricos a cada letra del string con función toCharArray (0 para primer caracter, 1 para segundo, etc.), sirve para referenciar los valores dentro del arreglo tipo char (en el ej. el llamado normal)
        char normal [] = c1.getFrase().toCharArray();
        
        String invert = "";
        
        //Defino un for para interar en el arreglo tipo char definido
        for (int i = normal.length-1; i>= 0; i--){
            invert+=normal[i];
        }
        System.out.println(invert);
    
    }
    
     public void vecesRepetido (Cadena c1){
           
           int repeticion = 0;
           String Frase = c1.getFrase().toUpperCase();
           System.out.println("Ingrece el caracter a verificar en mayuscula: ");
           String caracter = leer.next().toUpperCase();
           
           for (int i = 1; i < Frase.length()+1; i++){
                if (Frase.substring(i-1,i).equals(caracter)){
                    repeticion = repeticion + 1;
                }           
           }
           System.out.println("La cantidad de veces que se repite el caracter " + caracter + " es igual a: "+ repeticion);
     }
     
     
     public void compararFrase (Cadena c1){
           
           int longitud = c1.getLongitud();
           System.out.println("Ingrece la nueva frase a comparar la longitud : ");
           String fraseNueva = leer.next();
           int longitudNueva = fraseNueva.length();
           
           System.out.println("La cantidad de caracteres de la frase original es: " + longitud + " y de la nueva frase es: "+ longitudNueva);
     }
     
     
        public void unirFrase (Cadena c1){
           
           
           System.out.println("Ingrece la nueva frase a unir a la anterior : ");
           String fraseNueva = leer.next();
           System.out.println(c1.getFrase()+fraseNueva);
     }
     
        public void reemplazar (Cadena c1){
           
           
           System.out.println("Ingrece caracter a reemplazar por la letra a de la frase: ");
           
           String caracterReemplazo = leer.next();
           String Frase = c1.getFrase();
           String NuevaFrase = "";
           
            
           for (int i = 1; i < Frase.length()+1; i++){
                if (Frase.substring(i-1,i).equals("a")){
                    NuevaFrase += caracterReemplazo;
                } else {
                    NuevaFrase += Frase.substring(i-1,i);
                }          
           }
           System.out.println("La nueva frase es: " + NuevaFrase);
 
        }
     
        public void contiene (Cadena c1){
           
           
           System.out.println("Ingrece caracter a verificar si contiene la frase: ");
           
           String caracterVerif = leer.next();
           String Frase = c1.getFrase();
           int verificacion = 0;
           
            
           for (int i = 1; i < Frase.length()+1; i++){
                if (Frase.substring(i-1,i).equals(caracterVerif)){
                    verificacion = verificacion + 1;
                }      
           }
           System.out.println("La cantidad de veces que se repite el caracter en la frase es : " + verificacion);
 
        }
        
        
        
}